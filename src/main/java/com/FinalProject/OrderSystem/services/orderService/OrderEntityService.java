package com.FinalProject.OrderSystem.services.orderService;

import com.FinalProject.OrderSystem.models.OrderEntity;

import java.util.List;

public interface OrderEntityService {
    public void saveOrderEntity(OrderEntity orderEntity);

    List<OrderEntity> findAll();
}
