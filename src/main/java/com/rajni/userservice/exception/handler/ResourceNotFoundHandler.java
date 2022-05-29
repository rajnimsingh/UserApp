package com.rajni.userservice.exception.handler;

import com.rajni.userservice.exception.ResourceNotFoundException;
import com.rajni.userservice.exception.model.ErrorModel;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Writer;

@ControllerAdvice
public class ResourceNotFoundHandler {

    /*@ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void resourceNotFoundException(final Exception e, HttpServletRequest request, Writer writer) throws IOException {
        writer.write(ErrorModel.builder().errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value())).errorMessage(HttpStatus.BAD_REQUEST.name()).build().toString());
    }*/

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorModel> resourceNotFoundException() {
        return new ResponseEntity<>(ErrorModel.builder().errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value())).errorMessage(HttpStatus.BAD_REQUEST.name()).build()
        , HttpStatus.BAD_REQUEST);
    }
}
