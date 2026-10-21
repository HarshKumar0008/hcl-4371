package com.hcl.library.model;

public class Magazine extends LibraryItem {
    private final int issueNumber;

    public Magazine(String id, String title, int issueNumber) {
        super(id, title, ItemType.MAGAZINE);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() { return issueNumber; }
    @Override public int getLoanDays() { return 7; }

    @Override
    public String toString() {
        return super.toString() + " | Issue: " + issueNumber;
    }
}
