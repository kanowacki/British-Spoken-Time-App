package com.exercise.knowacki.SpokenTimeApp.controller.exception;

import com.exercise.knowacki.SpokenTimeApp.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleIllegalArgumentException(IllegalArgumentException e, WebRequest request) {

        return new Error(HttpStatus.BAD_REQUEST.value(), extractHourFromRequest(request), e.getClass().getSimpleName(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleOtherExceptions(Exception e, WebRequest request) {

        return new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), extractHourFromRequest(request), e.getClass().getSimpleName(), e.getMessage());
    }

    private String extractHourFromRequest(WebRequest request) {
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        String uri = servletWebRequest.getRequest().getRequestURI();
        return uri.substring(uri.lastIndexOf("/") + 1);
    }
}
