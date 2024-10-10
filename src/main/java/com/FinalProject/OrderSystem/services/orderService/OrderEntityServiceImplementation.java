package com.FinalProject.OrderSystem.services.orderService;

import com.FinalProject.OrderSystem.models.OrderEntity;
import com.FinalProject.OrderSystem.repositories.OrderEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderEntityServiceImplementation implements OrderEntityService {
    OrderEntityRepository orderEntityRepository;
    @Autowired
    public OrderEntityServiceImplementation(OrderEntityRepository orderEntityRepository) {
        this.orderEntityRepository = orderEntityRepository;
    }

    @Override
    public void saveOrderEntity(OrderEntity orderEntity) {
        orderEntityRepository.save(orderEntity);
    }

    @Override
    public List<OrderEntity> findAll() {
        return orderEntityRepository.findAll();
    }
}
