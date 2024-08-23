package com.social.learning.ticket.api.error;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiError {

  private String message;
  private int code;

  public ApiError(HttpStatus code) {
    this.code = code.value();
  }

}