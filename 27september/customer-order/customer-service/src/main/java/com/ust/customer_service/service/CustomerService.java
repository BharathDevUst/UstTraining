package com.ust.customer_service.service;

import java.util.List;

import com.ust.customer_service.model.CustomerPojo;

public interface CustomerService {
    List<CustomerPojo> getAllCustomers();
    CustomerPojo getCustomer(long custId);
    CustomerPojo addCustomer(CustomerPojo customerPojo);
}
