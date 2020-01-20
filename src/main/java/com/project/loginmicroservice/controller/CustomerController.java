package com.project.loginmicroservice.controller;

import com.project.loginmicroservice.dto.CustomerDto;
import com.project.loginmicroservice.dto.ResponseDto;
import com.project.loginmicroservice.entity.Customer;
import com.project.loginmicroservice.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    boolean verifyUser(String customerId){
        return customerService.isUser(customerId);
    }


    ResponseDto<Customer> getUserDetails(String customerId){
        ResponseDto<Customer> responseDto = new ResponseDto<>();
        try{
            Customer customerCreated=customerService.getUserDetails(customerId);
            if(customerCreated.getCustomerId()!=null)
                responseDto.setData(customerCreated);
                responseDto.setSuccess(true);
            }catch (Exception e){
                responseDto.setSuccess(false);
                responseDto.setMessage("No such customer exists!!");
            }
        return responseDto;
    }


    ResponseDto<Customer> createUser(CustomerDto customerDto){
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        ResponseDto<Customer> responseDto = new ResponseDto<>();
        try{
            Customer customerCreated=customerService.createCustomer(customer);
            responseDto.setData(customerCreated);
            responseDto.setSuccess(true);
        }catch (Exception e){
            responseDto.setSuccess(false);
            responseDto.setMessage("Customer is not created!!");
        }
        return responseDto;
    }





}