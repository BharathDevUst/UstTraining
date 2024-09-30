package com.ust.customer_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerPojo {
    private long custId;
    private String custName;
    private List<OrderPojo> allOrders;
}
