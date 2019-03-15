package com.trevorstinson.booklog.controllers;

import com.trevorstinson.booklog.models.Book;
import com.trevorstinson.booklog.models.BookStatus;
import com.trevorstinson.booklog.models.data.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookDao bookDao;

    static ArrayList<Book> books = new ArrayList<>();

    // Path: /book
    @GetMapping(value = "")
    public String index(Model model) {
        return "redirect:library";
    }

    // Path /book/{id}
    @GetMapping(value = "{bookId}")
    public String viewBook(Model model, @PathVariable int bookId) {

        Book book = bookDao.findById(bookId).orElse(null);

        model.addAttribute("book", book);
        model.addAttribute("pageTitle", book.getTitle());

        return "book/detail";
    }

    // Path: /book/add
    @GetMapping(value = "add")
    public String displayAddBookForm(Model model) {

        model.addAttribute(new Book());
        model.addAttribute("bookStatuses", BookStatus.values());
        model.addAttribute("pageTitle", "Add Book");

        return "book/add";
    }

    @PostMapping(value = "add")
    public String processAddBookForm(Model model,
                                     @ModelAttribute @Valid Book book,
                                     Errors errors) {

        model.addAttribute("bookStatuses", BookStatus.values());
        model.addAttribute("pageTitle", "Add Book");

        if (errors.hasErrors()) {
            return "book/add";
        }

        bookDao.save(book);
        model.addAttribute("bookId", book.getId());

        return "redirect:/library";
    }

    // Path: /book/#/edit
    @GetMapping(value = "{bookId}/edit")
    public String showEditBookForm(Model model, @PathVariable int bookId) {

        Book book = bookDao.findById(bookId).orElse(null);
        model.addAttribute("book", book);
        model.addAttribute("bookStatuses", BookStatus.values());
        model.addAttribute("pageTitle", "Edit Book");

        return "book/edit";
    }

    @PostMapping(value = "{bookId}/edit")
    public String processEditBookForm(Model model,
                                      @ModelAttribute @Valid Book updatedBook,
                                      Errors errors,
                                      @PathVariable int bookId) {

        if (errors.hasErrors()) {
            return "book/edit";
        }

        Book book = bookDao.findById(bookId).orElse(null);

        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setIsbn(updatedBook.getIsbn());
        book.setPageCount(updatedBook.getPageCount());
        book.setStatus(updatedBook.getStatus());
        book.setDateStarted(updatedBook.getDateStarted());
        book.setDateFinished(updatedBook.getDateFinished());

        bookDao.save(book);

        model.addAttribute("bookId", book.getId());

        return "redirect:/book/{bookId}";
    }

    // book/remove/#
    @GetMapping(value = "/remove/{bookId}")
    public String removeBook(Model model, @PathVariable int bookId) {

        Book book = bookDao.findById(bookId).orElse(null);
        bookDao.delete(book);

        return "redirect:/library";
    }
}
