package com.services.providersgr6.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Provider {
    @Id
    String id;
    String name;
    String tip_document;
    Integer num_document;
    String city;
    String address;
    Integer phone_num;
    Integer mobile_num;
    Integer social_security;
    Double value;
    String password;
    String tip_user;

}
