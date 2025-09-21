package hh_backend.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh_backend.bookstore.domain.Category;
import hh_backend.bookstore.domain.CategoryRepository;
import hh_backend.bookstore.domain.Book;
import hh_backend.bookstore.domain.BookRepository;


@SpringBootApplication
public class BookstoreApplication {

	private static Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			Log.info("save some sample categories");
			Category category01 = new Category("Scifi");
			Category category02 = new Category("Horror");
			Category category03 = new Category("Fantasy");

			categoryRepository.save(category01);
			categoryRepository.save(category02);
			categoryRepository.save(category03);

			Log.info("fetch all categories");
			for (Category category : categoryRepository.findAll()) {
				Log.info(category.toString());
			}

			Log.info("save a couple of books");
			Book kirja01 = new Book("Dune", "Frank Herbert", 1965, "978-951-98548-9-2", 12.0);
			Book kirja02 = new Book("The Hobbit", "J.R.R. Tolkien", 1937, "978-951-98548-9-3", 10.0);
			Book kirja03 = new Book("Taikatalvi", "Tove Jansson", 1957, "978-951-98548-9-4", 8.0);
			
			bookRepository.save(kirja01);
			bookRepository.save(kirja02);
			bookRepository.save(kirja03);

			Log.info("fetch all books");
			for (Book book : bookRepository.findAll() ) {
				Log.info(book.toString());
			}

			

		};
	}

}
