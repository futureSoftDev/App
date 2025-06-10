package com.company.card.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "card")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardContactInfoDto {

    String message;

    Map<String, String> contactDetails;

    List<String> onCallSupport;
}