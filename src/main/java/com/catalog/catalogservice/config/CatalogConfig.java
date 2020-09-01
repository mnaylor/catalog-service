package com.catalog.catalogservice.config;

import com.catalog.catalogservice.repositories.EntryRepository;
import com.catalog.catalogservice.services.EntryService;
import com.catalog.catalogservice.services.EntryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.catalog.catalogservice")
public class CatalogConfig {
    @Bean
    public EntryService entryService() {
        return new EntryServiceImpl();
    }
}
