package com.scaler.productservice.controlleradvices;

import com.scaler.productservice.Exceptions.ProductNotExistsException;
import com.scaler.productservice.dtos.ArithmeticExceptionDto;
import com.scaler.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

//    @ExceptionHandler(ArithmeticException.class)
//    public ResponseEntity<Void> handleException(){
//        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(ArithmeticException.class) // using a dto for sending a message for ArithmeticException along with some status code.
    public ResponseEntity<ArithmeticExceptionDto> handleExceptionArithmeticDto(){
        ArithmeticExceptionDto arithmeticExceptionDto= new ArithmeticExceptionDto();
        arithmeticExceptionDto.setMessage("Something gone wrong");
        return new ResponseEntity<>(arithmeticExceptionDto,HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<ExceptionDto> handleProductNotExistsException(ProductNotExistsException exception){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(exception.getMessage());
        exceptionDto.setDetail("check the id as the product with the given id doesnt exists");
        return new ResponseEntity<>(exceptionDto,HttpStatus.OK);
    }
}
