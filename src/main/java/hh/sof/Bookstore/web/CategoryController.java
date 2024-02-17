package hh.sof.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof.Bookstore.domain.Category;
import hh.sof.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public String showCategoryList(Model model) {

        List<Category> categories = (List<Category>) categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categorylist";
    }

    @GetMapping("/add")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping("/savecategory")
    public String saveCategory(Category category) {
        categoryRepository.save(category);
        return "redirect:/category";
    }
}
