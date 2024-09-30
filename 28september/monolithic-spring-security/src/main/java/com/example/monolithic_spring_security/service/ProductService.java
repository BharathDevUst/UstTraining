package com.example.monolithic_spring_security.service;

import com.example.monolithic_spring_security.dao.ProductDao;
import com.example.monolithic_spring_security.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public Product getAProduct(long prodId) {
        return productDao.findById(prodId).get();
    }


    public Product addProduct(Product newProd) {
        productDao.saveAndFlush(newProd);
        return newProd;
    }
}
