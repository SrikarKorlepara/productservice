package com.scaler.productservice.services;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfCategoryService")
public class SelfCategoryService implements CategoryService{


    private CategoryRepository categoryRepository;

    @Autowired
    public SelfCategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Product> getInCategory(Long id) {
        return null;
    }
}
