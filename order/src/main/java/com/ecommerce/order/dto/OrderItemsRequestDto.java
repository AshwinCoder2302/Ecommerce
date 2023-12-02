package com.ecommerce.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsRequestDto {
    private Long id;
    private String skuCode;
    private Integer price;
    private Integer quantity;
}
