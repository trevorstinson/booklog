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

    // Path: /library/read
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
}
