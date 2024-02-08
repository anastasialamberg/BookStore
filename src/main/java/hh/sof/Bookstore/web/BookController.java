package hh.sof.Bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof.Bookstore.domain.Book;
import hh.sof.Bookstore.domain.BookRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("newBook", new Book());
        return "bookstore";
    }

    @GetMapping("/newbook")
    public String getNewBook(Model model) {
        model.addAttribute("newBook", new Book());
        return "addbook";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("newBook") Book newBook) {
        bookRepository.save(newBook);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Integer id, Model model) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            model.addAttribute("book", book);
            return "editbook";
        } else {
            return "redirect:/books";
        }
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Integer id, @ModelAttribute("book") Book updatedBook) {
        bookRepository.save(updatedBook);
        return "redirect:/books";
    }

}
