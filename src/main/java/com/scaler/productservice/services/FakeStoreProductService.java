package com.scaler.productservice.services;

import com.scaler.productservice.Exceptions.ProductNotExistsException;
import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")  // this is also a special class
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){

        this.restTemplate=restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product= new Product();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setId(fakeStoreProductDto.getId());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageURL(fakeStoreProductDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());

        return product;

    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        //int i = 1 / 0;
        FakeStoreProductDto productDto=restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        if (productDto == null) throw new ProductNotExistsException("Product with id : " + id + " does not exists.");
        return convertFakeStoreProductToProduct(productDto);

    }

    @Override
    public List<Product> getAllProducts(){
        FakeStoreProductDto[] productDto=restTemplate.getForObject("https://fakestoreapi.com/products/",FakeStoreProductDto[].class);
        List<Product> answer = new ArrayList<>();
        for(FakeStoreProductDto dto : productDto){
            answer.add(convertFakeStoreProductToProduct(dto));
        }
        return answer;
    }

    @Override
    public Product replaceProduct(Long id , Product product){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getImageURL());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreProductDto.class);
                                                                        // here fakeStoreProductDto is the request body that we will be sending to the client.
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakeStoreProductToProduct(response);
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
    public boolean deleteProduct(Long id) {
        return false;
    }

}
























