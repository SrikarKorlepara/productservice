package com.scaler.productservice;

import com.scaler.productservice.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductserviceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(ProductserviceApplication.class, args);

/*
		product.getId();   getters and setters automatically created because of lombok
		product.setId(123L);
*/

    }

}
