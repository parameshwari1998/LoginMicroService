package com.project.loginmicroservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.math.BigInteger;


@Getter
@Setter
public class CustomerDto {

    private String customerId;
    private String name;
    private String password;
    private String address;
    private BigInteger contactNo;
    private String loginMethod;
    private Email email;
    private String imageUrl;

}
