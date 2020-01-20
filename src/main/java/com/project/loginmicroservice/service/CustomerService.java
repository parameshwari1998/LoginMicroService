package com.project.loginmicroservice.service;

import com.project.loginmicroservice.entity.Customer;

public interface CustomerService {

    Customer createCustomer(Customer customer);
    boolean isUser(String id);
    Customer getUserDetails(String customerId);
}
