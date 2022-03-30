package com.maverick.InventoryManager.product.entity;

import com.maverick.InventoryManager.user.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductAddRemove {
    @Autowired
    private ProductInfo productInfo;
    private int quantity;
    private Date date;
    private String description;
    @Autowired
    private Users user;
}
