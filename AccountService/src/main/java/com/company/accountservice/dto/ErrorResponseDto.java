package com.company.accountservice.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorResponseDto {

    String apiPath;

    HttpStatus httpStatus;

    String message;

    LocalDateTime dateTime;
}
