package com.scaler.productservice.services;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfCategoryService")
public class SelfCategoryService implements CategoryService{
    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public List<Product> getInCategory(Long id) {
        return null;
    }
}
