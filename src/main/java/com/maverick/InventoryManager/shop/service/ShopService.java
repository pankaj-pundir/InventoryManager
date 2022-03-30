package com.maverick.InventoryManager.shop.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maverick.InventoryManager.shop.entity.Shops;
import com.maverick.InventoryManager.shop.repository.ShopRepository;
import com.maverick.InventoryManager.utils.InventoryResponse;
import com.maverick.InventoryManager.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class ShopService {
    @Autowired
    ShopRepository shopRepository;

    public InventoryResponse addShopDetails(Shops shop) throws JsonProcessingException {
//        shop = Utils.updateCreatedTime(shop);
        shopRepository.save(shop);

        InventoryResponse inventoryResponse = new InventoryResponse();
        inventoryResponse.setStatus("SUCCESS");
        inventoryResponse.setDescription("Shop details added");
        ObjectMapper objectMapper = new ObjectMapper();
        String shopInfo = objectMapper.writeValueAsString(shop);
        log.info("successfully added shop details.");
        inventoryResponse.setMetadata(shopInfo);

        return inventoryResponse;
    }
}
