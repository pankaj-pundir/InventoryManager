package com.maverick.InventoryManager.shop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maverick.InventoryManager.shop.entity.Shops;
import com.maverick.InventoryManager.shop.service.ShopService;
import com.maverick.InventoryManager.utils.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shops")
public class ShopController {
    @Autowired
    ShopService shopService;

    @PostMapping("/add")
    public ResponseEntity<InventoryResponse> addNewShop(
            @RequestBody Shops shop
            ) throws JsonProcessingException {

        InventoryResponse response = shopService.addShopDetails(shop);
//        generate the response entity for the api call
        ResponseEntity responseEntity = new ResponseEntity<>(response,
                response.getStatus().toLowerCase()
                        .equals("success")?
                        HttpStatus.CREATED:
                        HttpStatus.BAD_REQUEST);

        return responseEntity;

    }

}
