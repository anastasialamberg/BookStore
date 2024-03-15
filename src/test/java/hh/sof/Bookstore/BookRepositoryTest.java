package hh.sof.Bookstore;

import hh.sof.Bookstore.domain.Book;
import hh.sof.Bookstore.domain.BookRepository;
import hh.sof.Bookstore.domain.Category;
import hh.sof.Bookstore.domain.CategoryRepository;
import hh.sof.Bookstore.domain.User;
import hh.sof.Bookstore.domain.UserRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testBookRepository() {

        Book book = new Book(3, "Muumikirja", "Tove Jansson", 2020, "000003J", 15.90);
        bookRepository.save(book);

        Optional<Book> foundBooks = bookRepository.findById(3);
        assertThat(foundBooks).isNotEmpty();

        bookRepository.delete(book);

        assertThat(bookRepository.findById(3)).isEmpty();
    }

    @Test
    void testCategoryRepository() {

        Category category = new Category(3, "Fiction");
        categoryRepository.save(category);

        Optional<Category> foundCategories = categoryRepository.findById(3);
        assertThat(foundCategories).isNotEmpty();

        categoryRepository.delete(category);

        assertThat(categoryRepository.findById(3)).isEmpty();
    }

    @Test
    void testUserRepository() {

        User user = new User("maijam", "$2a$10$EFPDcnDkAlTQdSQbBCwa9uWo3xdRh4SaAeKuY7g9mTPIBhliT7SJ6",
                "maijam@gmail.com", "USER");
        userRepository.save(user);

        User foundUser = userRepository.findByUsername("maijam");
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUsername()).isNotEmpty();

        userRepository.delete(user);

        assertThat(userRepository.findByUsername("maijam")).isNull();
    }
}
