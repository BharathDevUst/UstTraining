package com.ust.order_service.dao;

import org.springframework.stereotype.Repository;
import com.ust.order_service.dao.entity.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByCustId(long custId);
}
