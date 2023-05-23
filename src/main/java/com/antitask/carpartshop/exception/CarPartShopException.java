package com.antitask.carpartshop.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class CarPartShopException extends Exception{
  private String name;
  private HttpStatus status;
  private Integer statusCode;
  private String message;
}
