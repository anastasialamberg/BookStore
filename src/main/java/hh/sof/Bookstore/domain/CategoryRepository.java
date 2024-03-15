package hh.sof.Bookstore.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Optional<Category> findById(Integer categoryId);

}
