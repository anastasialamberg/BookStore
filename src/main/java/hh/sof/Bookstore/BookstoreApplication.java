package hh.sof.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof.Bookstore.domain.Book;
import hh.sof.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			Book book1 = new Book("Harry Potter and the Philosopher's stone", "J.K.Rowling", 1997, "001", 48.50);
			Book book2 = new Book("The Hunger Games", "Suzanne Collins", 2008, "002", 22.00);

			bookRepository.save(book1);
			bookRepository.save(book2);
		};
	}

}
