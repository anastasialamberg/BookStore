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
			Book book1 = new Book("Kirja1", "Kirjailija1", 2000, "001", 20.00);
			Book book2 = new Book("Kirja2", "Kirjailija2", 2020, "002", 25.00);

			bookRepository.save(book1);
			bookRepository.save(book2);
		};
	}

}
