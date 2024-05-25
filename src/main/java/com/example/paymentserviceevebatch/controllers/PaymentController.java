package com.example.paymentserviceevebatch.controllers;

import com.example.paymentserviceevebatch.dtos.InitiatePaymentRequestDto;
import com.example.paymentserviceevebatch.services.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto requestDto)  {
        try {
            return paymentService.initiatePayment(
                    requestDto.getOrderId(),
                    requestDto.getAmount()
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping("/sample")
    public String sampleAPI() {
        return "Hello from Scaler";
    }
}
