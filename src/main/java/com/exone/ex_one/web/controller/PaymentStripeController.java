package com.exone.ex_one.web.controller;
import com.exone.ex_one.model.CustomerData;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentStripeController {
    @Value("${stripe.apikey}")
    String apiPrivateKey;
    @RequestMapping("/createCustomer")
    public CustomerData index(@RequestBody CustomerData customerData) throws StripeException {
        Stripe.apiKey = apiPrivateKey;
        CustomerCreateParams params = CustomerCreateParams.builder()
                        .setName(customerData.getName())
                        .setEmail(customerData.getEmail())
                        .build();
        Customer customer = Customer.create(params);
        customerData.setCustomerId(customer.getId());
        return customerData;
    }
}
