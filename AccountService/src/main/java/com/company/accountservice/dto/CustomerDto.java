package com.company.accountservice.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDto {

    String name;

    String email;

    String customerPhone;

    public CustomerDto(String name, String email, String customerPhone) {
        this.name = name;
        this.email = email;
        this.customerPhone = customerPhone;
    }
}
