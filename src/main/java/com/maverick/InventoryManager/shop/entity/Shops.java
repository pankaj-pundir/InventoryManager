package com.maverick.InventoryManager.shop.entity;

import com.maverick.InventoryManager.constants.CountryNames;
import com.maverick.InventoryManager.constants.ShopTypes;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "Shops")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shops {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long shopId;
    @NonNull
    @Column(unique = true,length = 40)
    private String shopName;
    private String address;
    private ShopTypes shopType;
    @NonNull
    @Column(length = 30)
    private String shopOwnerName;
    @Nullable
    private String shopOwnerEmail;
    @Nullable
    @Column(length = 10)
    private String shopOwnerNumber;
    private CountryNames country;

}
