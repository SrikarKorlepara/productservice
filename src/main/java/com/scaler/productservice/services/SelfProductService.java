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
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotExistsException{
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotExistsException("Product with the id : "+ id + " doesnt exist");
        }
        Product productToUpdate = productOptional.get();
        Optional<Category> categoryOptional = categoryRepository.findByName(product.getCategory().getName());
        if(categoryOptional.isEmpty()){
            Category savedCategory=categoryRepository.save(product.getCategory());
            productToUpdate.setCategory(savedCategory);
        }
        else{
            //productToUpdate.setCategory(product.getCategory()); for some reason this is not working. find out why
            productToUpdate.setCategory(categoryOptional.get());
        }
        productToUpdate.setTitle(product.getTitle());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setImageURL(product.getImageURL());
        return productRepository.save(productToUpdate);


    }

    @Override
    public Product addNewProduct(Product product) {
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
        Optional<Product> productOptional= productRepository.findById(id);
        if (productOptional.isEmpty()){
            throw new RuntimeException();
        }
        Product savedProduct = productOptional.get();

        if (product.getTitle()!=null){
            savedProduct.setTitle(product.getTitle());
        }
        if (product.getDescription()!=null){
            savedProduct.setDescription(product.getDescription());
        }
        if (product.getPrice()!=null){
            savedProduct.setPrice(product.getPrice());
        }
        if (product.getImageURL()!=null){
            savedProduct.setImageURL(product.getImageURL());
        }
        if (product.getCategory()!=null){
            savedProduct.setCategory(product.getCategory());
        }
        return productRepository.save(savedProduct);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }
}
