package com.maverick.InventoryManager.product.entity;

import lombok.NonNull;

public class ProductInfo {
    @NonNull
    private long productId;
    private String productType;
    private String productName;
    private String productRate;
    private String productDescription;
    private String productImage;
}
