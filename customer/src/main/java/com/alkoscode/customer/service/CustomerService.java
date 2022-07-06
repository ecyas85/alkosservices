package com.alkoscode.customer.service;

import com.alkoscode.amqp.publisher.RabbitMQMessageProducer;
import com.alkoscode.clients.fraud.FraudClient;
import com.alkoscode.clients.fraud.model.FraudCheckResponse;
import com.alkoscode.clients.notification.model.NotificationRequest;
import com.alkoscode.customer.model.Customer;
import com.alkoscode.customer.model.CustomerRegistrationRequest;
import com.alkoscode.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository,
                              FraudClient fraudClient,
                              RabbitMQMessageProducer rabbitMQMessageProducer) {
    public void registerCustomer(final CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);
        //todo: check if email valid
        //todo: check if email not taken
        //todo: check if fraudster
        final FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (Boolean.TRUE.equals(fraudCheckResponse.isFraudster())) {
            throw new IllegalStateException("Fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Alkoscode...", customer.getFirstName()));

        rabbitMQMessageProducer.publish("internal.exchange",
                "internal.notification.routing-key",
                notificationRequest);
    }
}
