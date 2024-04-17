package com.harjoitustyo.Neuletyot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.harjoitustyo.Neuletyot.model.Category;
import com.harjoitustyo.Neuletyot.model.CategoryRepository;


@Controller

public class CategoryController {

    @Autowired
    private CategoryRepository carepository;

    // Shows all categories, home page
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String ShowCategories(Model model) {
        model.addAttribute("category", carepository.findAll());
        return "category";
    }

    @RequestMapping(value = "/addcategory", method = RequestMethod.GET)
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }
    
    
    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String saveCategory(Category category) {
        carepository.save(category);
        return "redirect:category";
    }


}
