package com.mine.webshopapp.service;

import com.mine.webshopapp.dto.PaymentInfo;
import com.mine.webshopapp.dto.Purchase;
import com.mine.webshopapp.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo StripeException) throws StripeException;
}
