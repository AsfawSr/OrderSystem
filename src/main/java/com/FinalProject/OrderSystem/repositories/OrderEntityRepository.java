package com.FinalProject.OrderSystem.repositories;

import com.FinalProject.OrderSystem.models.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity,Long> {
}
