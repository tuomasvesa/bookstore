package hh_backend.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh_backend.bookstore.domain.Book;
import hh_backend.bookstore.domain.BookRepository;
import hh_backend.bookstore.domain.CategoryRepository;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookrepository;

    @Autowired
    private CategoryRepository cRepository;

    @Test
    public void createNewBook() {
        Book book = new Book("Best book", "Me", 2025, "1234567", 5.0, cRepository.findByName("Horror").get(0));
        bookrepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBookById() {
        List<Book> books = bookrepository.findByTitle("Dune");
        Long id = books.get(0).getId();
        bookrepository.deleteById(id);
        assertThat(bookrepository.findByTitle("Dune")).hasSize(0);

    }

    @Test
    public void findByTitle() {
        List<Book> books = bookrepository.findByTitle("Dune");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Frank Herbert");
    }

    @Test
    void findById() {
        List<Book> books = bookrepository.findByTitle("Dune");
        Long id = books.get(0).getId();
        Optional<Book> foundBook = bookrepository.findById(id);
        assertThat(foundBook).isPresent();
        assertThat(foundBook.get().getTitle()).isEqualTo("Dune");
    }

    @Test
    void findAll() {
        Iterable<Book> books = bookrepository.findAll();
        assertThat(books).hasSize(3);
    }

}
