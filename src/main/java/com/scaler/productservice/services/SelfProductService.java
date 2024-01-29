package com.scaler.productservice.services;

import com.scaler.productservice.Exceptions.ProductNotExistsException;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public SelfProductService(RestTemplate restTemplate){

        this.restTemplate=restTemplate;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        return null;
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
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }
}
