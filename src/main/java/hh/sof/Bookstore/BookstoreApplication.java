package hh.sof.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof.Bookstore.domain.Book;
import hh.sof.Bookstore.domain.BookRepository;
import hh.sof.Bookstore.domain.Category;
import hh.sof.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			Category category1 = new Category(null, "Fantasy");
			Category category2 = new Category(null, "Sci-fi");

			categoryRepository.save(category1);
			categoryRepository.save(category2);

			Book book1 = new Book(null, "Harry Potter and the Philosopher's stone", "J.K.Rowling", 1997, "001", 48.50);
			book1.setCategory(category1);
			bookRepository.save(book1);

			Book book2 = new Book(null, "The Hunger Games", "Suzanne Collins", 2008, "002", 22.00);
			book2.setCategory(category2);
			bookRepository.save(book2);
		};
	}

}
