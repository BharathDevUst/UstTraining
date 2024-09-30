package com.ust.customer_service.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @Column(name = "customer_id")
    private Long custId;

    @Column(name = "customer_name")
    private String custName;
}
