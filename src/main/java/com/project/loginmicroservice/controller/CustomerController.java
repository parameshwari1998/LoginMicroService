package com.project.loginmicroservice.controller;

import com.project.loginmicroservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class CustomerController {

    @Autowired
    CustomerService customerService;
}
