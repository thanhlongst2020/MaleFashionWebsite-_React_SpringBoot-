package com.malefashionshop.dto.response;

import com.malefashionshop.entities.CustomerEntity;
import com.malefashionshop.entities.OrderItemEntity;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDto {
    private Long id;
    private float totalPrice;
    private CustomerEntity customer;
    private List<OrderItemResponseDto> orderItemResponseDto;
}
