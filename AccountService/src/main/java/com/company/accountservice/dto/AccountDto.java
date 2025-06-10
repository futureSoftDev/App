package com.company.accountservice.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDto {

    String customerName;

    String customerEmail;

    String customerPhone;

    String accountType;
}
