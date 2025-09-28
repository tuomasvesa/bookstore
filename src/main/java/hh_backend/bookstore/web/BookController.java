package hh_backend.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh_backend.bookstore.domain.Book;
import hh_backend.bookstore.domain.BookRepository;
import hh_backend.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping("/index")
    public String getFrontPage() {
        return "index"; // index.html
    }

    @GetMapping("/booklist")
    public String getBookList(Model model) {
        model.addAttribute("books", bookRepo.findAll()); // haetaan tietokannasta kirja, select
        return "booklist"; // booklist/html
    }

    @GetMapping("/addbook")
    public String addNewBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepo.findAll());
        return "addbook"; // addbook.html
    }

    @PostMapping("/saveNewBook")
    public String saveNewBook(@ModelAttribute Book newBook) {
        bookRepo.save(newBook);
        return "redirect:/booklist"; // booklist.html
    }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        bookRepo.deleteById(bookId); // SQL Delete
        return "redirect:/booklist";
    }

    @GetMapping("/editbook/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", bookRepo.findById(bookId));
        return "editbookform"; // editbookform.html
    }

    @PostMapping("/updatebook")
    public String updateBook(@ModelAttribute Book updatedBook) {
        bookRepo.save(updatedBook);
        return "redirect:/booklist";
    }
}

