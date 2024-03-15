package hh.sof.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hh.sof.Bookstore.domain.Book;
import hh.sof.Bookstore.domain.BookRepository;
import hh.sof.Bookstore.domain.Category;
import hh.sof.Bookstore.domain.CategoryRepository;
import hh.sof.Bookstore.domain.User;
import hh.sof.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository,
			UserRepository userRepository) {
		return (args) -> {
			Logger logger = LoggerFactory.getLogger(BookstoreApplication.class);

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

			User user1 = new User("user", "$2a$10$my.VcIuboic9X1ABwp6fZ.2iBBVT1IMP4UuXel0tW.f/IpVqlIHVS",
					"user@gmail.com", "USER");
			User user2 = new User("admin", "$2a$10$y5CTOMgRK3hh2NDv4219he2Yh7I5CK3O7F6iZxUqcdZHtbfqP3y2W",
					"admin@gmail.com", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

			logger.info("Demo data added successfully.");
		};
	}

}
