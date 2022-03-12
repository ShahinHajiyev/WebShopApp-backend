package com.mine.webshopapp.dto;

import com.mine.webshopapp.entity.Address;
import com.mine.webshopapp.entity.Customer;
import com.mine.webshopapp.entity.Order;
import com.mine.webshopapp.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItemSet;




}
