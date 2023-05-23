package com.antitask.carpartshop.controller;

import java.util.HashMap;
import java.util.Map;
import com.antitask.carpartshop.exception.CarPartShopException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CarPartShopControllerAdvice {

  @ResponseBody
  @ExceptionHandler({CarPartShopException.class})
  ResponseEntity<ApiError> internalExceptionHandler(final CarPartShopException e ) {
    final Map<String, String> errors = new HashMap<>();
    final String errorMessage = e.getMessage();
    errors.put(e.getName(), errorMessage);
    final ApiError apiError = new ApiError(e.getStatus(), e.getStatus(), e.getMessage(), errors);
    return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
  }
}
