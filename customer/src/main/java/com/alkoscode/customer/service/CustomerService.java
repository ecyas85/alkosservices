package com.alkoscode.customer.service;

import com.alkoscode.customer.CustomerRegistrationRequest;
import com.alkoscode.customer.CustomerRepository;
import com.alkoscode.customer.model.Customer;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(final CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //todo: check if email valid
        //todo: check if email not taken
        //todo: check if fraudster
        customerRepository.save(customer);
        //todo: send a notification
    }
}
