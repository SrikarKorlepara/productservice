package com.scaler.productservice.services;

import com.scaler.productservice.Exceptions.ProductNotExistsException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private RestTemplate restTemplate;
    private ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public SelfProductService(RestTemplate restTemplate,ProductRepository productRepository,
                              CategoryRepository categoryRepository){

        this.restTemplate=restTemplate;
        this.productRepository=productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {

        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty())
        {
            throw new ProductNotExistsException("Product with the id: "+ id + " doesnt exist.");
        }
        return optionalProduct.get();

    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
//        Category category = product.getCategory();
//        if(category.getId() == null){
//            Category savedCategory= categoryRepository.save(category);
//            product.setCategory(savedCategory);
//        }

        Optional<Category> categoryOptional = categoryRepository.findByName(product.getCategory().getName());

        if (categoryOptional.isEmpty()){
            Category savedCategory = categoryRepository.save(product.getCategory());
            product.setCategory(savedCategory);
        }
        else{
            product.setCategory(categoryOptional.get());
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }
}
