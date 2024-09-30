package com.ust.customer_service.controller;

import java.util.List;

import com.ust.customer_service.model.CustomerPojo;
import com.ust.customer_service.model.OrderPojo;
import com.ust.customer_service.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api")
public class CustomerController {
    public static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    CustomerService custService;
    @Autowired
    public CustomerController(CustomerService custService) {
        this.custService = custService;
    }

    @GetMapping("/customers")
    public List<CustomerPojo> getAllCustomers() {
        LOG.info("in getAllCustomers");
        return custService.getAllCustomers();
    }

    @GetMapping("/customers/{cid}")
    public CustomerPojo getACustomer(@PathVariable("cid") long cid) {
        LOG.info("in getACustomer");
        CustomerPojo custPojo = custService.getCustomer(cid);
        RestClient restClient = RestClient.create();
        List<OrderPojo> allOrders = restClient.get().uri("http://localhost:8082/api/orders/customers/"+cid).retrieve().body(List.class);
        custPojo.setAllOrders(allOrders);
        return custPojo;
    }

    public CustomerPojo ordFallback() {
        return new CustomerPojo(0, "fallback", null);
    }

    @PostMapping("/customers")
    public CustomerPojo addCustomer(@RequestBody CustomerPojo newPojo) {
        LOG.info("in addCustomer");
        return custService.addCustomer(newPojo);
    }
}
