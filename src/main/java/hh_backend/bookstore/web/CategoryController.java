package hh_backend.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import hh_backend.bookstore.domain.Category;
import hh_backend.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    @GetMapping("/categorylist")
    public String getCategoryList(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "categorylist"; // categorylist.html
    }

    @GetMapping("/addcategory")
    public String getCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory"; // addcategory.html
    }

    @PostMapping("/savecategory")
    public String saveNewCategory(@ModelAttribute Category newCategory) {
        repository.save(newCategory);
        return "redirect:/categorylist";
    }
}
