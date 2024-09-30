package com.ust.customer_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.customer_service.dao.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    
}
