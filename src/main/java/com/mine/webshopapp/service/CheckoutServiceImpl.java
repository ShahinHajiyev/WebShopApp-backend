package com.mine.webshopapp.service;

import com.mine.webshopapp.dao.CustomerRepository;
import com.mine.webshopapp.dto.Purchase;
import com.mine.webshopapp.dto.PurchaseResponse;
import com.mine.webshopapp.entity.Customer;
import com.mine.webshopapp.entity.Order;
import com.mine.webshopapp.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        //retrieve the order info from dto
        Order order = purchase.getOrder();

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber );

        //populate order with orderItems
        Set<OrderItem> orderItemSet = purchase.getOrderItems();
        orderItemSet.forEach(item -> order.add(item));

        //populating order with billing and shipping addresses
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());


        //populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        //save to the database
        customerRepository.save(customer);

        //return response
        return  new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        //generate a random UUID number

        return UUID.randomUUID().toString();
    }
}
