package com.trevorstinson.booklog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("book")
public class BookController {

    @GetMapping(value = "")
    public String index(Model model) {
        model.addAttribute("bookTitle", "Dune");
        model.addAttribute("bookAuthor", "Frank Herbert");
        return "book/index";
    }

    @GetMapping(value = "goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye Reader";
    }

}
