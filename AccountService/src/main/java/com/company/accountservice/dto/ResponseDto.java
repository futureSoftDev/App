package com.company.accountservice.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseDto<T> {

    private static final Object EMPTY_OBJECT = new Object();

    HttpStatus status;

    T data;

    ErrorResponseDto error;

    public ResponseDto(HttpStatus status, T data, ErrorResponseDto error) {
        this.status = status;
        this.error = error;
        this.data = data;
    }

    @SuppressWarnings("unchecked")
    public static <T> ResponseDto<T> onError(ErrorResponseDto error, HttpStatus status) {
        return new ResponseDto<>(status, (T) EMPTY_OBJECT, error);
    }

    public ResponseDto(HttpStatus status, T data) {
        this.status = status;
        this.data = data;
    }

    public static <T> ResponseDto<T> onSuccess(T data) {
        return new ResponseDto<>(HttpStatus.OK, data);
    }

    @SuppressWarnings("unchecked")
    public static <T> ResponseDto<T> onSuccess() {
        return new ResponseDto<>(HttpStatus.OK,(T)EMPTY_OBJECT);
    }
}
