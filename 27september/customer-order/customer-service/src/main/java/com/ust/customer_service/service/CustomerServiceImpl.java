package com.ust.customer_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.customer_service.dao.CustomerRepository;
import com.ust.customer_service.dao.entity.CustomerEntity;
import com.ust.customer_service.model.CustomerPojo;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository custRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepository custRepo) {
        this.custRepo = custRepo;
    }

    @Override
    public List<CustomerPojo> getAllCustomers() {
        List<CustomerEntity> customers = custRepo.findAll();
        List<CustomerPojo> customerList = customers.stream().map(cust -> {
            CustomerPojo customerPojo = new CustomerPojo();
            BeanUtils.copyProperties(cust, customerPojo);
            return customerPojo;
        }).toList();
        return customerList;
    }

    @Override
    public CustomerPojo getCustomer(long custId) {
        Optional<CustomerEntity> customer = custRepo.findById(custId);
        CustomerPojo customerPojo = null;
        if (customer.isPresent()) {
            customerPojo = new CustomerPojo();
            BeanUtils.copyProperties(customer.get(), customerPojo);
        }
        return customerPojo;
    }

    @Override
    public CustomerPojo addCustomer(CustomerPojo customerPojo) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customerPojo, customerEntity);
        custRepo.saveAndFlush(customerEntity);
        return customerPojo;
    }
    
}
