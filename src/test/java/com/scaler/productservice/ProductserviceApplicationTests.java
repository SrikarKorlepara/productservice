package com.scaler.productservice;

import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.ProductRepository;
import com.scaler.productservice.repositories.projections.ProductWithIdAndTitle;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;

@SpringBootTest
class ProductserviceApplicationTests {
	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	@Commit
	void testQueries(){

//		productRepository.findByTitleContaining("Srikar");
//		productRepository.deleteByTitle("Srikar");


//		List<Product> products = productRepository.something();
//		for( Product product : products){
//			System.out.println(product.getTitle());
//			System.out.println(product.getId());
//			System.out.println(product.getCategory().getName());
//		}


//		List<ProductWithIdAndTitle> products = productRepository.somethingsomething(53L);
//
//		for ( ProductWithIdAndTitle product : products){
//			System.out.println(product.getId());
//		 	System.out.println(product.getTitle());
//		}

//		List<Product> products = productRepository.somesome2();
//		for ( Product product : products){
//			System.out.println(product.getId());
//		 	System.out.println(product.getTitle());
//		}

	}
}





















