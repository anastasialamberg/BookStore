package hh.sof.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof.Bookstore.domain.Book;
import hh.sof.Bookstore.domain.BookRepository;
import hh.sof.Bookstore.domain.Category;
import hh.sof.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("newBook", new Book());
        return "bookstore";
    }

    @GetMapping("/newbook")
    public String getNewBook(Model model) {
        model.addAttribute("newBook", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("newBook") Book newBook) {
        bookRepository.save(newBook);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteBook(@PathVariable("id") Integer id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Integer id, Model model) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            List<Category> categories = (List<Category>) categoryRepository.findAll();
            model.addAttribute("book", book);
            model.addAttribute("categories", categories);
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
