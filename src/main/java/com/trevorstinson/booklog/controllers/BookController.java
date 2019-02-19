package com.trevorstinson.booklog.controllers;

import com.trevorstinson.booklog.models.Book;
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

        model.addAttribute("books", books);
        model.addAttribute("pageTitle", "Booklog");

        return "book/index";
    }

    // Path: /book/add
    @GetMapping(value = "add")
    public String displayAddBookForm(Model model) {

        model.addAttribute(new Book());
        model.addAttribute("pageTitle", "Add Book");

        return "book/add";
    }

    @PostMapping(value = "add")
    public String processAddBookForm(Model model,
                                     @ModelAttribute @Valid Book book,
                                     Errors errors) {

        if (errors.hasErrors()) {
            return "book/add";
        }

        bookDao.save(book);

        return "redirect:list";
    }

    // Path: /book/list
    @GetMapping(value = "list")
    public String showBookList(Model model) {

        model.addAttribute("books", bookDao.findAll());
        model.addAttribute("pageTitle", "Booklog");

        Integer pageTotal = 0;

        for (Book book : books) {
            pageTotal = pageTotal + book.getPageCount();
        }

        model.addAttribute("pageTotal", pageTotal);

        return "book/list";
    }

    @GetMapping(value = "goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye Reader";
    }

}
