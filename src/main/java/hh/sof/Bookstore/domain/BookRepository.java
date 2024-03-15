package hh.sof.Bookstore.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

    Optional<Book> findById(Integer id);

}
