package com.scaler.productservice.services;

import com.scaler.productservice.Exceptions.ProductNotExistsException;
import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotExistsException;
    List<Product> getAllProducts();
    Product replaceProduct(Long id,Product product) throws ProductNotExistsException;
    Product addNewProduct(Product product);
    Product updateProduct(Long id,Product product) throws ProductNotExistsException;
    boolean deleteProduct(Long id);


}
