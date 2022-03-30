package com.maverick.InventoryManager;

import com.maverick.InventoryManager.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@EnableAutoConfiguration
public class InventoryManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagerApplication.class, args);

//
//        ProductService productService = new ProductService();
//        productService.initializeDb();
//        log.info("Initialied the db");
	}

}
