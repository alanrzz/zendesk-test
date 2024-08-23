package com.social.learning.ticket.api.error;

import com.social.learning.ticket.api.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(Exception.class)
  protected ResponseEntity<Object> AllUnhandledExceptions(Exception ex) {
    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
    apiError.setMessage(ex.getMessage());
    return this.buildResponse(apiError);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  protected ResponseEntity<Object> ResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
    apiError.setMessage(resourceNotFoundException.getMessage());
    return this.buildResponse(apiError);
  }

  @ExceptionHandler(WebClientResponseException.class)
  protected ResponseEntity<Object> ResourceNotFoundException(WebClientResponseException webClientResponseException) {
    ApiError apiError = new ApiError( (HttpStatus) webClientResponseException.getStatusCode() );
    apiError.setMessage(webClientResponseException.getMessage());
    return this.buildResponse(apiError);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  protected ResponseEntity<Object> DataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException) {
    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
    apiError.setMessage(dataIntegrityViolationException.getMessage());
    return buildResponse(apiError);
  }

  private ResponseEntity<Object> buildResponse(ApiError apiError) {
    return ResponseEntity.status(apiError.getCode()).body(apiError);
  }

}