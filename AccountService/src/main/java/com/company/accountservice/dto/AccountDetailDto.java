package com.company.accountservice.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDetailDto {
    Long id;

    String accountType;

    String accountNumber;

    CustomerDto customer;
}