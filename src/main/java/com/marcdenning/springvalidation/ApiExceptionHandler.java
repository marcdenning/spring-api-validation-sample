package com.marcdenning.springvalidation;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class ApiExceptionHandler {

    private static Logger logger = Logger.getLogger(ApiExceptionHandler.class.getName());

    private final MessageSource messageSource;

    public ApiExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public ErrorResponse handleMethodArgumentNotValid(
            BindException ex,
            Locale locale
    ) {
        final ObjectError error = ex.getBindingResult().getAllErrors().get(0);
        final String message = messageSource.getMessage(error, locale);

        logger.log(Level.SEVERE, ex.getMessage(), ex);

        return ErrorResponse.create(ex, HttpStatus.BAD_REQUEST, message);
    }
}
