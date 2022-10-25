package com.malefashionshop.mappers;

import com.malefashionshop.dto.request.OrderItemUpdateDto;
import com.malefashionshop.dto.request.OrderUpdateDto;
import com.malefashionshop.dto.response.OrderItemResponseDto;
import com.malefashionshop.dto.response.OrderResponseDto;
import com.malefashionshop.dto.response.ProductDetailResponseDto;
import com.malefashionshop.entities.OrderEntity;
import com.malefashionshop.entities.OrderItemEntity;
import com.malefashionshop.entities.ProductDetailEntity;
import com.malefashionshop.exceptions.DataConstrainConflictException;
import com.malefashionshop.exceptions.ResourceNotFoundException;
import com.malefashionshop.repository.*;
import com.malefashionshop.service.impl.OrderItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderEntityAndOrderResponseDtoMapper {
    @Autowired
    OrderItemEntityAndOrderItemResponseDtoMapper orderItemEntityAndResponseDtoMapper;
    @Autowired
    OrderItemRepository orderItemRepository;

    public void map(OrderEntity orderEntity, OrderResponseDto orderResponseDto){
        BeanUtils.copyProperties(orderEntity, orderResponseDto);

        orderResponseDto.setCustomer(null);// Tạm thời, vì chưa tạo Customer

        List<OrderItemResponseDto> listOrderItemResponseDto = new ArrayList<>();
        if(orderEntity.getOrderItems()!= null) {
            orderEntity.getOrderItems().forEach(orderItemEntity -> {
                OrderItemResponseDto orderItemResponseDto = new OrderItemResponseDto();
                this.orderItemEntityAndResponseDtoMapper.map(orderItemEntity, orderItemResponseDto);
                listOrderItemResponseDto.add(orderItemResponseDto);
            });
            orderResponseDto.setOrderItemResponseDto(listOrderItemResponseDto);
        } else{
            orderResponseDto.setOrderItemResponseDto(null);
        }

    }

    public void map(OrderUpdateDto orderUpdateDto, OrderEntity orderEntity){

//        orderEntity.setCustomer(null); // Tạm thời vì chưa có Customer
//
//        List<OrderItemEntity> listOrderItemEntity = new ArrayList<>();
//        orderUpdateDto.getOrderItemID().forEach(id ->{
//            Optional<OrderItemEntity> optionalOrderItemEntity = this.orderItemRepository.findById(id);
//            if(optionalOrderItemEntity.isEmpty()){
//                throw new ResourceNotFoundException("Order Item with ID: "+id+ "can be not found");
//            }
//            listOrderItemEntity.add(optionalOrderItemEntity.get());
//        });
//        orderEntity.setOrderItems(listOrderItemEntity);


    }
}
