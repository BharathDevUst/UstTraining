package com.example.monolithic_spring_security.controller;

import com.example.monolithic_spring_security.entity.Product;
import com.example.monolithic_spring_security.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService prodService;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return prodService.getAllProducts();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/products/{pid}")
    public Product getAProduct(@PathVariable("pid") int prodId) {
        return prodService.getAProduct(prodId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product newProd) {
        return prodService.addProduct(newProd);
    }
}

