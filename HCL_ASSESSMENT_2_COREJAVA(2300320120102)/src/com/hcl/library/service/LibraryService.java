package com.hcl.library.service;

import com.hcl.library.exception.LibraryException;
import com.hcl.library.model.*;
import com.hcl.library.repository.LibraryRepository;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class LibraryService {
    private static final double FEE_PER_DAY = 5.0;
    private final LibraryRepository repository;

    public LibraryService(LibraryRepository repository) {
        this.repository = repository;
    }

    public void addItem(LibraryItem item) throws LibraryException {
        if (repository.getItems().containsKey(item.getId()))
            throw new LibraryException("An item with this ID already exists.");
        repository.getItems().put(item.getId(), item);
    }

    public void registerMember(Member member) throws LibraryException {
        if (repository.getMembers().containsKey(member.getId()))
            throw new LibraryException("A member with this ID already exists.");
        repository.getMembers().put(member.getId(), member);
    }

    public Collection<LibraryItem> getItems() {
        return Collections.unmodifiableCollection(repository.getItems().values());
    }

    public Collection<Member> getMembers() {
        return Collections.unmodifiableCollection(repository.getMembers().values());
    }

    public void issueItem(String itemId, String memberId) throws LibraryException {
        LibraryItem item = repository.getItems().get(itemId);
        Member member = repository.getMembers().get(memberId);
        if (item == null) throw new LibraryException("Item ID not found.");
        if (member == null) throw new LibraryException("Member ID not found.");

        if (!item.isAvailable()) {
            Queue<String> queue = repository.getWaitingLists()
                    .computeIfAbsent(itemId, k -> new LinkedList<>());
            if (!queue.contains(memberId))
                queue.offer(memberId);
            throw new LibraryException(queue.contains(memberId)
                    ? "Item is borrowed. Member is on the waiting list (or already queued)."
                    : "Item is borrowed.");
        }

        item.setAvailable(false);
        Loan loan = new Loan(item, member, LocalDate.now(),
                LocalDate.now().plusDays(item.getLoanDays()));
        repository.getActiveLoans().put(itemId, loan);
        repository.getLoanHistory().add(loan);
        System.out.println("Issued successfully. Due date: " + loan.getDueDate());
    }

    public double returnItem(String itemId) throws LibraryException {
        Loan loan = repository.getActiveLoans().remove(itemId);
        if (loan == null) throw new LibraryException("This item has no active loan.");

        double fee = loan.close(LocalDate.now(), FEE_PER_DAY);
        loan.getItem().setAvailable(true);
        System.out.printf(Locale.US, "Returned. Late fee: ₹%.2f%n", fee);

        Queue<String> queue = repository.getWaitingLists().get(itemId);
        while (queue != null && !queue.isEmpty()) {
            String nextMemberId = queue.poll();
            if (repository.getMembers().containsKey(nextMemberId)) {
                System.out.println("Next on waiting list: " +
                        repository.getMembers().get(nextMemberId).getName() +
                        " (Member ID: " + nextMemberId + "). Issue this item to them next.");
                break;
            }
        }
        return fee;
    }

    public void showWaitingList(String itemId) throws LibraryException {
        if (!repository.getItems().containsKey(itemId))
            throw new LibraryException("Item ID not found.");
        Queue<String> queue = repository.getWaitingLists().get(itemId);
        if (queue == null || queue.isEmpty()) {
            System.out.println("Waiting list is empty.");
            return;
        }
        int position = 1;
        for (String memberId : queue) {
            Member member = repository.getMembers().get(memberId);
            System.out.println(position++ + ". " +
                    (member == null ? memberId : member.getName() + " (" + memberId + ")"));
        }
    }

    public void showLoans() {
        if (repository.getActiveLoans().isEmpty()) {
            System.out.println("No active loans.");
            return;
        }
        for (Loan loan : repository.getActiveLoans().values()) {
            System.out.println(loan.getItem().getTitle() + " | Item ID: " +
                    loan.getItem().getId() + " | Member: " + loan.getMember().getName() +
                    " | Issued: " + loan.getIssueDate() + " | Due: " + loan.getDueDate());
        }
    }

    public void exportReport(String fileName) throws IOException {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            out.println("Item ID,Type,Title,Available,Current Borrower,Due Date,Waiting List Size");
            for (LibraryItem item : repository.getItems().values()) {
                Loan loan = repository.getActiveLoans().get(item.getId());
                Queue<String> queue = repository.getWaitingLists().get(item.getId());
                String borrower = loan == null ? "" : loan.getMember().getName();
                String due = loan == null ? "" : loan.getDueDate().toString();
                out.printf("%s,%s,%s,%s,%s,%s,%d%n",
                        csv(item.getId()), item.getType(), csv(item.getTitle()),
                        item.isAvailable(), csv(borrower), due, queue == null ? 0 : queue.size());
            }
        }
    }

    private String csv(String value) {
        if (value == null) return "";
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }
}
