package com.FinalProject.Bank.services.orderService;

import com.FinalProject.Bank.models.OrderEntity;
import com.FinalProject.Bank.repositories.OrderEntityRepository;
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
