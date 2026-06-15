package com.r4hul.EmpTrack.common.advice;

import com.r4hul.EmpTrack.common.advice.responseHandler.ApiResponse;
import com.r4hul.EmpTrack.common.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException e){
        ApiError error = ApiError
                .builder()
                .status(HttpStatus.NOT_FOUND)
                .message("Resource for " + e.getMessage() + " Not_Found")
                .build();

        return new ResponseEntity<>(new ApiResponse(error),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ApiError> allOtherException(Exception e){
        ApiError apiError = ApiError
                .builder()
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(apiError,HttpStatus.METHOD_NOT_ALLOWED);
    }
}
