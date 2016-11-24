package com.tel_ran.hederkosher.rest.common.controller;

import com.tel_ran.hederkosher.rest.ServiceResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import static com.tel_ran.hederkosher.rest.ServiceResultFactory.Type;
import static com.tel_ran.hederkosher.rest.ServiceResultFactory.getResultObject;
import static com.tel_ran.hederkosher.service.Loggers.restLogger;

@RestController
public class Controller {

    @ExceptionHandler(InvalidRequestException.class)
    public @ResponseBody ResponseEntity<Object> handleInvalidRequest(InvalidRequestException ex, WebRequest request) {
        System.out.println("+++Invalid request:");
        restLogger.error("Invalid request: ", ex);

        /*String bodyOfResponse = "Something went wrong!";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);*/

        return ResponseEntity
                .badRequest()
                .body(getResultObject(Type.INVALID_REQUEST));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public @ResponseBody ResponseEntity<ServiceResult> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        restLogger.error("Bad request: ", e);
        return ResponseEntity
                .badRequest()
                .body(getResultObject(Type.INVALID_REQUEST));
    }

    @ExceptionHandler(Exception.class)
    public @ResponseBody ResponseEntity<ServiceResult> handleException(Exception e){
        restLogger.error("Internal server error: ", e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(getResultObject(Type.SERVER_ERROR));
    }

}
