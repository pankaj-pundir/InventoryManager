package com.maverick.InventoryManager.inventory.entity;

import com.maverick.InventoryManager.utils.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Inventory")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Inventory extends BaseEntity {

    @NonNull
    @Id
    @Column(name = "product_id")
    private Long productId;
    //thinking that the class can be linked to another entity

    @Column(name = "product_count")
    private Long productCount;


}
