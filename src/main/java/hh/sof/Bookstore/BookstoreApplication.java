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
			Book book1 = new Book(1, "Harry Potter and the Philosopher's stone", "J.K.Rowling", 1997, "001", 48.50);
			Book book2 = new Book(2, "The Hunger Games", "Suzanne Collins", 2008, "002", 22.00);

			bookRepository.save(book1);
			bookRepository.save(book2);

			Iterable<Book> books = bookRepository.findAll();
			for (Book book : books) {
				System.out.println(" Book: " + " Id:" + book.getId() + " , Title: " + book.getTitle() + " , Author: "
						+ book.getAuthor()
						+ ", Publication Year: " + book.getPublicationYear() + " , Isbn " + book.getIsbn()
						+ " , Price: " + book.getPrice());
			}

			Category category1 = new Category(1, "Fantasy");
			Category category2 = new Category(2, "Sci-fi");

			categoryRepository.save(category1);
			categoryRepository.save(category2);

			Iterable<Category> categories = categoryRepository.findAll();
			for (Category category : categories) {
				System.out.println("Category: " + " Id: " + category.getCategoryId() + " Name: " + category.getName());
			}
		};
	}

}
