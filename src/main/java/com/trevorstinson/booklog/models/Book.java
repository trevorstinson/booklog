package com.trevorstinson.booklog.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, max=75)
    private String title;

    @NotNull
    @Size(min=1, max=75)
    private String author;

    @NotNull
    private Integer pageCount;

    @Size(min=10, max=13)
    private String isbn;

    @NotNull
    private BookStatus status;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDate dateStarted;
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDate dateFinished;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Readthrough> readthroughs = new ArrayList<>();


    public Book() {}


    public Book(String title,
                String author,
                Integer pageCount,
                String isbn,
                BookStatus status) {

        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.status = status;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

//    public LocalDate getDateStarted() {
//        return dateStarted;
//    }
//
//    public void setDateStarted(LocalDate dateStarted) {
//        this.dateStarted = dateStarted;
//    }
//
//    public LocalDate getDateFinished() {
//        return dateFinished;
//    }
//
//    public void setDateFinished(LocalDate dateFinished) {
//        this.dateFinished = dateFinished;
//    }


    public List<Readthrough> getReadthroughs() {
        return readthroughs;
    }

    public void setReadthroughs(List<Readthrough> readthroughs) {
        this.readthroughs = readthroughs;
    }
}
