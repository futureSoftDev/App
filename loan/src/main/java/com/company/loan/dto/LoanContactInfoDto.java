package com.company.loan.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "loan")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanContactInfoDto {


    String message;

    Map<String, String> contactDetails;

    List<String> onCallSupport;
}