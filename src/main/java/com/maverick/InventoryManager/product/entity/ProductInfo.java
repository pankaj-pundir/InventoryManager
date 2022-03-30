package com.maverick.InventoryManager.product.entity;

import com.maverick.InventoryManager.utils.BaseEntity;
import lombok.*;

import javax.persistence.*;


// Created an Entity and db entries data.
// used lombok for class initialization

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Table(name = "Product")
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    public String type;
    @NonNull
    @Column(unique = true,name="name")
    public String name;
    public Float price;
    public String description;
    public String imageURL;

}
