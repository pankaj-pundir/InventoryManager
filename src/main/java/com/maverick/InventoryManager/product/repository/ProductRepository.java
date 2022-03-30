package com.maverick.InventoryManager.product.repository;

import com.maverick.InventoryManager.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, Long> {
    List<ProductInfo> findAll();
    ProductInfo findById(long id);
    void deleteById(long id);
    ProductInfo save(ProductInfo pi);
}
