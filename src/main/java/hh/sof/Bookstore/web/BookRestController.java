package hh.sof.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof.Bookstore.domain.Book;
import hh.sof.Bookstore.domain.BookRepository;

@CrossOrigin
@Controller
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/bookRest")
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/bookRest/{id}")
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Integer id) {
        return bookRepository.findById(id);
    }

    @PostMapping("/bookRest")
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {
        return bookRepository.save(book);
    }
}
