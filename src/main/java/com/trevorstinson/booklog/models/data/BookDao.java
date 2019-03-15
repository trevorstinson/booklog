package com.trevorstinson.booklog.models.data;


import com.trevorstinson.booklog.models.Book;
import com.trevorstinson.booklog.models.BookStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
@Transactional
public interface BookDao extends CrudRepository<Book, Integer> {

    Iterable<Book> findByTitle(String title);

    Iterable<Book> findByAuthor(String author);

    Iterable<Book> findByPageCount(Integer pageCount);

    Iterable<Book> findByStatus(BookStatus status);

    Iterable<Book> findByStatusNot(BookStatus status);

    Iterable<Book> findByIsbn(String isbn);

    Iterable<Book> findByDateStarted(LocalDate dateStarted);

    Iterable<Book> findByDateFinished(LocalDate dateFinished);

}
