package hh_backend.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh_backend.bookstore.domain.Book;
import hh_backend.bookstore.domain.BookRepository;

@RestController
public class BookRestController {

    @Autowired
    private BookRepository bookRepo;

    @GetMapping("/books")
    public @ResponseBody List<Book> getBookListRest() {
        return (List<Book>) bookRepo.findAll();
    }

    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> findBookById(@PathVariable("id") Long bookId) {
        return bookRepo.findById(bookId);
    }

}
