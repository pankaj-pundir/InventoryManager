package com.maverick.InventoryManager.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class InventoryResponse {
    String status;
    String description;
    String metadata;
}
