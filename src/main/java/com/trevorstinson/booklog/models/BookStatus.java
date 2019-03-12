package com.trevorstinson.booklog.models;

public enum BookStatus {

    INTERESTED ("Interested"),
    READING ("Reading"),
    FINISHED ("Finished"),
    INACTIVE  ("Inactive");

    private final String name;

    BookStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
