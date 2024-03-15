package hh.sof.Bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import hh.sof.Bookstore.web.BookController;
import hh.sof.Bookstore.web.BookRestController;
import hh.sof.Bookstore.web.CategoryController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;

	@Autowired
	private CategoryController categoryController;

	@Autowired
	private BookRestController bookRestController;

	@Test
	void contextLoads() {
		assertThat(bookController).isNotNull();
		assertThat(categoryController).isNotNull();
		assertThat(bookRestController).isNotNull();
	}
}
