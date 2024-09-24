package com.FinalProject.Bank.services.orderService;

import com.FinalProject.Bank.models.OrderEntity;

import java.util.List;

public interface OrderEntityService {
    public void saveOrderEntity(OrderEntity orderEntity);

    List<OrderEntity> findAll();
}
