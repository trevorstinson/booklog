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

//        model.addAttribute("books", books);
//        model.addAttribute("pageTitle", "Booklog");

//        return "book/index";
        return "redirect:book/list";
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

//        return "redirect:book/{bookId}";
        return "redirect:/book/list";
    }

    @GetMapping(value = "/remove/{bookId}")
    public String removeBook(Model model, @PathVariable int bookId) {

        Book book = bookDao.findById(bookId).orElse(null);

        bookDao.delete(book);

        return "redirect:/book/list";
    }

    // Path: /book/list
    @GetMapping(value = "list")
    public String showBookList(Model model) {

        Iterable<Book> books = bookDao.findAll();

        model.addAttribute("books", books);
        model.addAttribute("pageTitle", "All Books");

        Integer pageTotal = 0;

        for (Book book : books) {
            pageTotal = pageTotal + book.getPageCount();
        }

        model.addAttribute("pageTotal", pageTotal);

        return "book/table";
    }

    @GetMapping(value = "search")
    public String bookSearch(Model model) {

        return "book/search";

    }

}
