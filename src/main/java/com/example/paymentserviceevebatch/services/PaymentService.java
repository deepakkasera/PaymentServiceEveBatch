package com.example.paymentserviceevebatch.services;

import com.example.paymentserviceevebatch.paymentgateway.PaymentGateway;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String initiatePayment(Long orderId, Long amount) throws RazorpayException, StripeException {
        //Make a call to Payment Gateway to generate the payment link.
        return paymentGateway.generatePaymentLink(orderId, amount);
    }
}
