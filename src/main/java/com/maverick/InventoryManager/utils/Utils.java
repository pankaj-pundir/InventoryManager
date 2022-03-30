package com.maverick.InventoryManager.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maverick.InventoryManager.shop.entity.Shops;
import com.maverick.InventoryManager.shop.repository.ShopRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;


@Slf4j
// no need to set the setter and getter or any args
// that is only needed for beans and if the class is autowired
public class Utils {

    public static final BaseEntity updateCreatedTime(BaseEntity obj){
        obj.setCreatedAt(LocalDateTime.now());
        obj.setUpdatedAt(LocalDateTime.now());
        return obj;
    }

    public static boolean isShopExists(long shopId,ShopRepository shopRepository) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Shops> shop = shopRepository.findById(shopId);
        String shop_string = mapper.writeValueAsString(shop);
        log.info("shop value by id ",shop_string);

        if(shop.isPresent())
            return true;
        return false;
    }
}
