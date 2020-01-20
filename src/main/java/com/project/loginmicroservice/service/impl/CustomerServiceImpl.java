package com.project.loginmicroservice.service.impl;

import com.project.loginmicroservice.entity.Customer;
import com.project.loginmicroservice.repository.CustomerRepository;
import com.project.loginmicroservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean isUser(String id) {
        return customerRepository.existsById(id);
    }

    @Override
    public Customer getUserDetails(String customerId) {
        return (customerRepository.existsById(customerId))?customerRepository.findById(customerId).get():null;
    }
}
