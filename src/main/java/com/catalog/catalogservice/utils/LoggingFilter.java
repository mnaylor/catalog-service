package com.catalog.catalogservice.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class LoggingFilter extends AbstractRequestLoggingFilter {

    @Override
    protected void beforeRequest(final HttpServletRequest request, final String message) {
    }

    @Override
    protected void afterRequest(final HttpServletRequest request, final String message) {
        log.info(message);
    }
}
