package com.hcl.library.model;

public class DVD extends LibraryItem {
    private final int durationMinutes;

    public DVD(String id, String title, int durationMinutes) {
        super(id, title, ItemType.DVD);
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() { return durationMinutes; }
    @Override public int getLoanDays() { return 7; }

    @Override
    public String toString() {
        return super.toString() + " | Duration: " + durationMinutes + " min";
    }
}
