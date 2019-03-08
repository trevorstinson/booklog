package com.trevorstinson.booklog.controllers;

import com.trevorstinson.booklog.models.Book;

import com.trevorstinson.booklog.models.User;
import com.trevorstinson.booklog.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;
    static ArrayList<Book> books = new ArrayList<>();

//    // Path: /book
//    @GetMapping(value = "")
//    public String index(Model model) {
//
////        model.addAttribute("books", books);
////        model.addAttribute("pageTitle", "Booklog");
//
////        return "book/index";
//        return "redirect:book/list";
//    }
//
//    // Path /book/{id}
//    @GetMapping(value = "{bookId}")
//    public String viewBook(Model model, @PathVariable int bookId) {
//
//        Book book = bookDao.findById(bookId).orElse(null);
//        model.addAttribute("pageTitle", book.getTitle());
//
//        model.addAttribute("book", book);
//
//        return "book/detail";
//    }

    // Path: /user/add
    @GetMapping(value = "add")
    public String displayAddUserForm(Model model) {

        model.addAttribute(new User());
        model.addAttribute("pageTitle", "Add User");

        return "user/add";
    }

    @PostMapping(value = "add")
    public String processAddUserForm(Model model,
                                     @ModelAttribute @Valid User user,
                                     Errors errors) {

        if (errors.hasErrors()) {
            return "user/add";
        }

        userDao.save(user);

        return "redirect:list";
    }

//    // Path: /book/list
//    @GetMapping(value = "list")
//    public String showBookList(Model model) {
//
//        Iterable<Book> books = bookDao.findAll();
//
//        model.addAttribute("books", books);
//        model.addAttribute("pageTitle", "All Books");
//
//        Integer pageTotal = 0;
//
//        for (Book book : books) {
//            pageTotal = pageTotal + book.getPageCount();
//        }
//
//        model.addAttribute("pageTotal", pageTotal);
//
//        return "book/list";
//    }
//
//    @GetMapping(value = "search")
//    public String bookSearch(Model model) {
//
//        return "book/search";
//
//    }

}
