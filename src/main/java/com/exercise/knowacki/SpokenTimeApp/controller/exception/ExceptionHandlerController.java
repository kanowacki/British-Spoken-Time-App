package com.exercise.knowacki.SpokenTimeApp.controller.exception;

import com.exercise.knowacki.SpokenTimeApp.model.ErrorDto;
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
    public ErrorDto handleIllegalArgumentException(IllegalArgumentException e, WebRequest request) {

        return buildErrorDto(HttpStatus.BAD_REQUEST, e, request);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleOtherExceptions(Exception e, WebRequest request) {

        return buildErrorDto(HttpStatus.BAD_REQUEST, e, request);
    }

    private ErrorDto buildErrorDto(HttpStatus status, Exception e, WebRequest request) {

        return ErrorDto.builder()
                .statusCode(status.value())
                .requestedHour(extractHourFromRequest(request))
                .error(e.getClass().getSimpleName())
                .errorMessage(e.getMessage())
                .build();
    }

    private String extractHourFromRequest(WebRequest request) {
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        String uri = servletWebRequest.getRequest().getRequestURI();
        return uri.substring(uri.lastIndexOf("/") + 1);
    }
}
