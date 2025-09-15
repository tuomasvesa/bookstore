package hh_backend.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import hh_backend.bookstore.domain.Book;


@Controller
public class BookController {

    public ArrayList<Book> books = new ArrayList<Book>();

    @GetMapping("/index")
    public String getFrontPage() {
        return "index"; // index.html
    }

    @GetMapping("/booklist")
    public String getBookList(Model model) {
        model.addAttribute("books", books);
        return "booklist"; // booklist/html
    }

}
