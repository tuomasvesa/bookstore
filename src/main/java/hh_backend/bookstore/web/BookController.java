package hh_backend.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh_backend.bookstore.domain.Book;
import hh_backend.bookstore.domain.BookRepository;


@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @GetMapping("/index")
    public String getFrontPage() {
        return "index"; // index.html
    }

    @GetMapping("/booklist")
    public String getBookList(Model model) {
        model.addAttribute("books", repository.findAll()); // haetaan tietokannasta kirja, select
        return "booklist"; // booklist/html
    }

    @GetMapping("/addbook")
    public String addNewBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook"; // addbook.html

    }

    @PostMapping("/saveNewBook")
    public String saveNewBook(@ModelAttribute Book newBook) {
        repository.save(newBook);
        return "redirect:/booklist"; // booklist.html
    }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        repository.deleteById(bookId); // SQL Delete
        return "redirect:/booklist";
    }

    @GetMapping("/editbook/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", repository.findById(bookId));
        return "editbookform"; // editbookform.html
    }

    @PostMapping("/updatebook")
    public String updateBook(@ModelAttribute Book updatedBook) {
        repository.save(updatedBook);
        return "redirect:/booklist";
    }
}

