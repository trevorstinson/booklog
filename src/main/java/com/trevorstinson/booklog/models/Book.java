package com.trevorstinson.booklog.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, max=25)
    private String title;

    @NotNull
    @Size(min=1, max=25)
    private String author;

    private Integer pageCount;

    @Size(min=10, max=10)
    private String isbn_10;

    @Size(min=13, max=13)
    private String isbn_13;

    @NotNull
    public BookStatus status;


    public Book() {}


    public Book(String title,
                String author,
                Integer pageCount,
                String isbn_10,
                String isbn_13,
                BookStatus status) {

        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.isbn_10 = isbn_10;
        this.isbn_13 = isbn_13;
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

    public String getIsbn_10() {
        return isbn_10;
    }

    public void setIsbn_10(String isbn_10) {
        this.isbn_10 = isbn_10;
    }

    public String getIsbn_13() {
        return isbn_13;
    }

    public void setIsbn_13(String isbn_13) {
        this.isbn_13 = isbn_13;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
