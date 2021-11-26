package com.example.demo.exception;

import com.example.demo.ui.ErrorResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserServiceExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseModel> handleUniqueIdNotFoundException(UniqueIdNotFoundException e)
    {
        ErrorResponseModel errorResponseModel=new ErrorResponseModel();
        errorResponseModel.setMessage(e.getMessage());
        errorResponseModel.setErrorReportingTime(System.currentTimeMillis());
        errorResponseModel.setStatusCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseModel);

    }
}
