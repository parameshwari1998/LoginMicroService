package com.project.loginmicroservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@Table(name = Customer.CUSTOMER_TABLE_NAME)
public class Customer {

    public static final String CUSTOMER_TABLE_NAME = "CUSTOMER";

    @Id
    private String customerId;
    private String name;
    private String address;
    private BigInteger contactNo;
    private String email;
    private String imageUrl;

}
