package com.maverick.InventoryManager.product.controller;

import com.maverick.InventoryManager.product.entity.ProductInfo;
import com.maverick.InventoryManager.product.repository.ProductRepository;
import com.maverick.InventoryManager.product.service.ProductService;
import com.maverick.InventoryManager.utils.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    ProductRepository  repo;

    @Autowired
    ProductService productService;
//    = new ProductService();
//

    @GetMapping("/details")
    public List<ProductInfo> allProductDetails() {
        return repo.findAll();
    }
//
    @GetMapping("/id/{id}")
    public ProductInfo getProductInfoById(@PathVariable(value = "id") long id) {
        return repo.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<InventoryResponse> addNewProduct(
            @RequestBody ProductInfo productEntity) throws Exception {
//        get the actual response
        InventoryResponse response = productService.saveNewProduct(productEntity);
//        generate the response entity for the api call
        ResponseEntity responseEntity = new ResponseEntity<>(response,
                response.getStatus().toLowerCase()
                        .equals("success")?
                        HttpStatus.CREATED:
                        HttpStatus.BAD_REQUEST);

        return responseEntity;
    }

}
