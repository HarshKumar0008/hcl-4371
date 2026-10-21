package com.hcl.library.model;

public class Book extends LibraryItem {
    private final String author;

    public Book(String id, String title, String author) {
        super(id, title, ItemType.BOOK);
        this.author = author;
    }

    public String getAuthor() { return author; }
    @Override public int getLoanDays() { return 14; }

    @Override
    public String toString() {
        return super.toString() + " | Author: " + author;
    }
}
