package com.maverick.InventoryManager.user.entity;

import com.maverick.InventoryManager.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String phoneNumber;
    private Date date;
    private String address;
    private String about;
    private String category;
}
