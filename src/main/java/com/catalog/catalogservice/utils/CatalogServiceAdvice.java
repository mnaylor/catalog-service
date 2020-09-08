package com.catalog.catalogservice.utils;

import com.catalog.catalogservice.exceptions.CatalogServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CatalogServiceAdvice extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler({CatalogServiceException.class})
    ResponseEntity<String> exceptionHandler(CatalogServiceException ex, WebRequest request) {
        CatalogServiceException.ServiceException exceptionType = ex.getExceptionType();
        return new ResponseEntity(exceptionType.message, exceptionType.status);
    }
}
