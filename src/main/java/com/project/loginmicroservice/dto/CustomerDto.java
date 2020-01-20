package com.project.loginmicroservice.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigInteger;

@Getter
@Setter
public class CustomerDto {

    private String customerId;
    private String name;
    private String address;
    private BigInteger contactNo;
    private String email;
    private String imageUrl;

}
