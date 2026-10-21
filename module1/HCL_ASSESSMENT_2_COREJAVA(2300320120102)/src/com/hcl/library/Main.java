package com.hcl.library;

import com.hcl.library.exception.LibraryException;
import com.hcl.library.model.*;
import com.hcl.library.repository.LibraryRepository;
import com.hcl.library.service.LibraryService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private static final LibraryService SERVICE =
            new LibraryService(new LibraryRepository());

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");
            try {
                switch (choice) {
                    case 1: addItem(); break;
                    case 2: registerMember(); break;
                    case 3: listItems(); break;
                    case 4: listMembers(); break;
                    case 5: issueItem(); break;
                    case 6: returnItem(); break;
                    case 7: showLoans(); break;
                    case 8: showWaitingList(); break;
                    case 9: exportReport(); break;
                    case 0: running = false; System.out.println("Goodbye!"); break;
                    default: System.out.println("Invalid option. Try again.");
                }
            } catch (LibraryException | IOException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
            System.out.println();
        }
        SC.close();
    }

    private static void printMenu() {
        System.out.println("===== COLLEGE LIBRARY =====");
        System.out.println("1. Add item");
        System.out.println("2. Register member");
        System.out.println("3. List items");
        System.out.println("4. List members");
        System.out.println("5. Issue item");
        System.out.println("6. Return item");
        System.out.println("7. Show active loans");
        System.out.println("8. Show waiting list");
        System.out.println("9. Export CSV report");
        System.out.println("0. Exit");
    }

    private static void addItem() throws LibraryException {
        System.out.println("1. Book  2. Magazine  3. DVD");
        int type = readInt("Item type: ");
        String id = readText("Item ID: ");
        String title = readText("Title: ");
        LibraryItem item;
        switch (type) {
            case 1:
                item = new Book(id, title, readText("Author: "));
                break;
            case 2:
                item = new Magazine(id, title, readInt("Issue number: "));
                break;
            case 3:
                item = new DVD(id, title, readInt("Duration in minutes: "));
                break;
            default:
                throw new IllegalArgumentException("Choose type 1, 2, or 3.");
        }
        SERVICE.addItem(item);
        System.out.println("Item added.");
    }

    private static void registerMember() throws LibraryException {
        String id = readText("Member ID: ");
        String name = readText("Member name: ");
        String email = readText("Email: ");
        SERVICE.registerMember(new Member(id, name, email));
        System.out.println("Member registered.");
    }

    private static void listItems() {
        if (SERVICE.getItems().isEmpty()) {
            System.out.println("No items found.");
            return;
        }
        SERVICE.getItems().forEach(System.out::println);
    }

    private static void listMembers() {
        if (SERVICE.getMembers().isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        SERVICE.getMembers().forEach(System.out::println);
    }

    private static void issueItem() throws LibraryException {
        SERVICE.issueItem(readText("Item ID: "), readText("Member ID: "));
    }

    private static void returnItem() throws LibraryException {
        SERVICE.returnItem(readText("Item ID to return: "));
    }

    private static void showLoans() {
        SERVICE.showLoans();
    }

    private static void showWaitingList() throws LibraryException {
        SERVICE.showWaitingList(readText("Item ID: "));
    }

    private static void exportReport() throws IOException {
        String file = readText("Report filename (blank for library-report.csv): ");
        if (file.trim().isEmpty()) file = "library-report.csv";
        SERVICE.exportReport(file);
        System.out.println("Report exported to: " + file);
    }

    private static String readText(String prompt) {
        System.out.print(prompt);
        String value = SC.nextLine().trim();
        if (value.isEmpty()) throw new IllegalArgumentException("Value cannot be empty.");
        return value;
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(SC.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please enter a whole number.");
        }
    }
}
