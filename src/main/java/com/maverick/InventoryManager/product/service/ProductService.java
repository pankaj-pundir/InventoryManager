package com.maverick.InventoryManager.product.service;

import com.maverick.InventoryManager.product.entity.ProductInfo;
import com.maverick.InventoryManager.product.repository.ProductRepository;
import com.maverick.InventoryManager.shop.repository.ShopRepository;
import com.maverick.InventoryManager.utils.InventoryResponse;
import com.maverick.InventoryManager.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class ProductService implements Serializable {

    @Autowired ProductRepository repo ;
    @Autowired
    ShopRepository shopRepository;

//    @Autowired Utils utils;
//    Utils utils = new Utils();
//
    /*
    get the list of names of product currently
    available in the system
     */
    List<String> getListOfProductNames() {
        List<String> productNames = new ArrayList<>();

        for(ProductInfo pi : repo.findAll()) productNames.add(pi.getName());
        return productNames;
    }

    boolean isProductNameAvailable(String productName) {
        List<String> productNames = getListOfProductNames();
        for(String p : productNames) if(p.equals(productName)) return false;
        return true;
    }

    public InventoryResponse saveNewProduct(ProductInfo pi) throws Exception {
        // product name should be diff
        InventoryResponse inventoryResponse = new InventoryResponse();

        try {
            // does shop exist check ?

            if (!Utils.isShopExists(pi.getShopId(),shopRepository))
                throw new Exception("Shop Id not found");

            // update timestamp values
            pi = (ProductInfo) Utils.updateCreatedTime(pi);

            if(isProductNameAvailable(pi.getName()))
            {
                repo.save(pi);
                inventoryResponse.setStatus("SUCCESS");
                inventoryResponse.setDescription("Name created");
            }
            else
            throw new Exception("Name already present");

        }
        catch(Exception e){
            inventoryResponse.setStatus("FAILED");
            inventoryResponse.setDescription(e.getMessage());

        }


        return inventoryResponse;
    }


    // TODO initialize DB step with dummy data.
    public void initializeDb(){

        // DONE: add element in the table
        ProductInfo pi = new ProductInfo(1L,"game","badminton",
                400F,"to play game","");
//        repo.save(pi);
        repo.findAll();
    }

}
