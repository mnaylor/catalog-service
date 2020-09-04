package com.catalog.catalogservice.controllers;

import com.catalog.catalogservice.models.Pattern;
import com.catalog.catalogservice.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthController {

    public HealthController() {
    }

    @GetMapping("/health")
    Boolean all() {
        return true;
    }

}
