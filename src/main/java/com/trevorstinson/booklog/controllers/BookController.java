package com.trevorstinson.booklog.controllers;

import com.trevorstinson.booklog.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;


@Controller
@RequestMapping("book")
public class BookController {

    static ArrayList<Book> books = new ArrayList<>();

    @GetMapping(value = "")
    public String index(Model model) {

        model.addAttribute("books", books);
        model.addAttribute("pageTitle", "Booklog");

        return "book/index";
    }

    @GetMapping(value = "add")
    public String displayAddBookForm(Model model) {

        model.addAttribute("books", books);
        model.addAttribute("pageTitle", "Add Book");
        return "book/add";
    }

    @GetMapping(value = "goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye Reader";
    }

}
