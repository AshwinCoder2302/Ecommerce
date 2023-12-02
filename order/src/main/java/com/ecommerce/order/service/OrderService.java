package com.ecommerce.order.service;

import com.ecommerce.order.dto.OrderItemsRequestDto;
import com.ecommerce.order.dto.OrderRequestDto;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderItems;
import com.ecommerce.order.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderItemRepository orderItemRepository;

    public String placeOrder(OrderRequestDto orderRequestDto){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderItems> orderItems = orderRequestDto.getOrderItemsRequestDto()
                .stream()
                .map(orderItemsDto ->mapToDto(orderItemsDto,order))
                .toList();
        orderItemRepository.saveAll(orderItems);
        return "Order Placed Successfully";
    }

    public OrderItems mapToDto(OrderItemsRequestDto orderItemsDto, Order order){
        OrderItems orderItems = new OrderItems();
        orderItems.setOrder(order);
        orderItems.setPrice(orderItemsDto.getPrice());
        orderItems.setQuantity(orderItemsDto.getQuantity());
        orderItems.setSkuCode(orderItemsDto.getSkuCode());
        return orderItems;
    }

    public List<OrderItems> getOrder() {
        return orderItemRepository.findAll();
    }
}
