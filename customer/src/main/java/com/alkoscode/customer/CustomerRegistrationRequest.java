package com.alkoscode.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
