package com.mine.webshopapp.service;

import com.mine.webshopapp.dto.Purchase;
import com.mine.webshopapp.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
