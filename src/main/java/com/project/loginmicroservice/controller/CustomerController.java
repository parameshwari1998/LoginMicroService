package com.project.loginmicroservice.controller;

import com.project.loginmicroservice.dto.CustomerDto;
import com.project.loginmicroservice.dto.ResponseDto;
import com.project.loginmicroservice.entity.Customer;
import com.project.loginmicroservice.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @GetMapping("/verify")
    boolean verifyMerchant(@RequestHeader("customerId") String customerId){
        return customerService.isUser(customerId);
    }


    @GetMapping("/")
    ResponseDto<Customer> getUserDetails(@RequestHeader("customerId") String customerId){
        ResponseDto<Customer> responseDto = new ResponseDto<>();
        try{
            Customer customerCreated=customerService.getUserDetails(customerId);
            customerCreated.setCustomerId("");
            responseDto.setData(customerCreated);
            responseDto.setSuccess(true);
            }catch (Exception e){
                responseDto.setSuccess(false);
                responseDto.setMessage("No such customer exists!!");
            }
        return responseDto;
    }


    @PostMapping("/")
    ResponseDto<Customer> createUser(@RequestBody CustomerDto customerDto,@RequestHeader("customerId") String customerId,@RequestHeader("customerEmail") String customerEmail){
        Customer customer=new Customer();
        customerDto.setEmail(customerEmail);
        BeanUtils.copyProperties(customerDto,customer);
        customer.setCustomerId(customerId);
        ResponseDto<Customer> responseDto = new ResponseDto<>();
        try{
            Customer customerCreated=customerService.createCustomer(customer);
            customerCreated.setCustomerId("");
            responseDto.setData(customerCreated);
            responseDto.setSuccess(true);
        }catch (Exception e){
            responseDto.setSuccess(false);
            responseDto.setMessage("Customer is not created!!");
        }
        return responseDto;
    }


    @PostMapping("/update")
    ResponseDto<Customer> updateUser(@RequestBody CustomerDto customerDto,@RequestHeader("customerId") String customerId){
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customer.setCustomerId(customerId);
        ResponseDto<Customer> responseDto = new ResponseDto<>();
        try{
            Customer customerCreated=customerService.createCustomer(customer);
            customerCreated.setCustomerId("");
            responseDto.setData(customerCreated);
            responseDto.setSuccess(true);
        }catch (Exception e){
            responseDto.setSuccess(false);
            responseDto.setMessage("Profile is not updated!!");
        }
        return responseDto;
    }

}