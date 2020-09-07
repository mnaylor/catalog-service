package com.catalog.catalogservice.exceptions;

import com.catalog.catalogservice.models.EntryType;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CatalogServiceException extends RuntimeException {
    public enum ServiceException {
        EntryNotFoundException(HttpStatus.NOT_FOUND, "Pattern or fabric entry not found"),
        RepositoryException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception occurred with repository");

        public HttpStatus status;
        public String message;

        ServiceException(HttpStatus status, String message) {
            this.status = status;
            this.message = message;
        }

    }

    private ServiceException exceptionType;
    private String message;
    private Exception innerException;

    public CatalogServiceException(ServiceException exceptionType) {
        this.exceptionType = exceptionType;
    }

    public CatalogServiceException(ServiceException exceptionType, Exception innerException) {
        this.exceptionType = exceptionType;
        this.innerException = innerException;
    }
}
