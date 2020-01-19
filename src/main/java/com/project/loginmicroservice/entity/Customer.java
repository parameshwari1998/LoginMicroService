package com.project.loginmicroservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@Table(name="CUSTOMER")
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String customerId;
    private String name;
    private String password;
    private String address;
    private BigInteger contactNo;
    private String loginMethod;
    private Email email;
    private String imageUrl;

}
