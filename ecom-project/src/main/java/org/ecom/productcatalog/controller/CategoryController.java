package org.ecom.productcatalog.controller;

import org.ecom.productcatalog.model.Category;
import org.ecom.productcatalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @GetMapping
    public List<Category> getCategoryService() {
        return categoryService.getAllCategories();
    }
}
