package com.maverick.InventoryManager.shop.repository;

import com.maverick.InventoryManager.shop.entity.Shops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shops, Long> {
}
