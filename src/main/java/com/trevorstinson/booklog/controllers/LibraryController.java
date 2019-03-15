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
@RequestMapping("library")
public class LibraryController {

    @Autowired
    private BookDao bookDao;

    static ArrayList<Book> books = new ArrayList<>();

    // Path: /library
    @GetMapping(value = "")
    public String index(Model model) {

        Iterable<Book> books = bookDao.findAll();

        model.addAttribute("books", books);
        model.addAttribute("pageTitle", "Library: All Books");

        Integer pageTotal = 0;

        for (Book book : books) {
            pageTotal = pageTotal + book.getPageCount();
        }

        model.addAttribute("pageTotal", pageTotal);

        return "library/index";
    }

    // Path: /library/interested
    @GetMapping(value = "interested")
    public String listInterestedBooks(Model model) {

        Iterable<Book> books = bookDao.findByStatus(BookStatus.INTERESTED);

        model.addAttribute("books", books);
        model.addAttribute("pageTitle", "Library: Interested");

        Integer pageTotal = 0;

        for (Book book : books) {
            pageTotal = pageTotal + book.getPageCount();
        }

        model.addAttribute("pageTotal", pageTotal);

        return "library/index";
    }

    // Path: /library/reading
    @GetMapping(value = "reading")
    public String listReadingBooks(Model model) {

        Iterable<Book> books = bookDao.findByStatus(BookStatus.READING);

        model.addAttribute("books", books);
        model.addAttribute("pageTitle", "Library: Reading");

        Integer pageTotal = 0;

        for (Book book : books) {
            pageTotal = pageTotal + book.getPageCount();
        }

        model.addAttribute("pageTotal", pageTotal);

        return "library/index";
    }

    // Path: /library/finished
    @GetMapping(value = "finished")
    public String listFinishedBooks(Model model) {

        Iterable<Book> books = bookDao.findByStatus(BookStatus.FINISHED);

        model.addAttribute("books", books);
        model.addAttribute("pageTitle", "Library: Finished");

        Integer pageTotal = 0;

        for (Book book : books) {
            pageTotal = pageTotal + book.getPageCount();
        }

        model.addAttribute("pageTotal", pageTotal);

        return "library/index";
    }

    // Path: /library/inactive
    @GetMapping(value = "inactive")
    public String listInactiveBooks(Model model) {

        Iterable<Book> books = bookDao.findByStatus(BookStatus.INACTIVE);

        model.addAttribute("books", books);
        model.addAttribute("pageTitle", "Library: Inactive");

        Integer pageTotal = 0;

        for (Book book : books) {
            pageTotal = pageTotal + book.getPageCount();
        }

        model.addAttribute("pageTotal", pageTotal);

        return "library/index";
    }
}
