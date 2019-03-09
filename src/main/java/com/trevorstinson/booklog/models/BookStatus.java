package com.trevorstinson.booklog.models;

public enum BookStatus {

    READING ("Reading Now"),
    FINISHED ("Finished"),
    INTERESTED ("Interested"),
    INACTIVE  ("Inactive");

    private final String name;

    BookStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
