package com.scaler.productservice.controllers;


import com.scaler.productservice.Exceptions.ProductNotExistsException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
//    FakeStoreProductService, which is an implementation of the ProductService Interface is also
//    a special class which is annotated as @Service. therefore we can use the autowired annotation
//    here since we will also be having a bean of ProductService in the applicationcontext of Spring
//    Here we don't have any conflict since ProductService class is implemented by only one class.
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService=productService;
    }

    @GetMapping() // serves request at localhost:8080/products
    public ResponseEntity<List<Product>> getAllProducts(){
        ResponseEntity<List<Product>> response = new ResponseEntity<>(
                productService.getAllProducts(), HttpStatus.NOT_FOUND
        );

        return response;
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) throws ProductNotExistsException {

        return productService.getSingleProduct(id);
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product){
        Product p = new Product();
        p.setTitle("A new Product");
        return p;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product){

        return productService.replaceProduct(id,product);

    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id,@RequestBody Product product){

    }

    @ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<Void> handleProductNotExistException(){
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

}
