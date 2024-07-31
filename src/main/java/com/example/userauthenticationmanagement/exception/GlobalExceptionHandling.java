package com.example.userauthenticationmanagement.exception;

import com.example.userauthenticationmanagement.dto.ErrorDetail;
import com.example.userauthenticationmanagement.dto.ValidationErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorDto> handleValidationErrors(MethodArgumentNotValidException e) {
        List<ValidationErrorDto.Error> errorList = e.getBindingResult().getAllErrors()
                .stream().map(error -> ValidationErrorDto.Error.builder().field(((FieldError) error)
                        .getField()).message(error.getDefaultMessage()).build()).toList();

        ValidationErrorDto validationErrorDto = ValidationErrorDto.builder().errors(errorList).build();
        return new ResponseEntity<>(validationErrorDto, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handleGlobalExceptions(Exception e, WebRequest webRequest) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), e.getMessage(), webRequest
                .getDescription(false));
        return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
