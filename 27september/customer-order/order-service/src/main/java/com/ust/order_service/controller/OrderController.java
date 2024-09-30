package com.ust.order_service.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.order_service.dao.OrderRepository;
import com.ust.order_service.dao.entity.OrderEntity;

@RestController
@RequestMapping("/api/")
public class OrderController {
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    OrderRepository ordRepo;

    public OrderController(OrderRepository ordRepo) {
        this.ordRepo = ordRepo;
    }
    @PostMapping("/order")
    public OrderEntity createOrder(@RequestBody OrderEntity order) {
        return ordRepo.saveAndFlush(order);
    }
    @GetMapping("/order/{id}")
    public OrderEntity getOrder(@PathVariable("id") long id) {
        Optional<OrderEntity> order =  ordRepo.findById(id);
        return order.get();
    }
    @GetMapping("/orders")
    public List<OrderEntity> getOrdersByCustId(@PathVariable("custId") long custId) {
        return ordRepo.findByCustId(custId);
    }
}
