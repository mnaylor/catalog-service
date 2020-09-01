package com.catalog.catalogservice.controllers;

import com.catalog.catalogservice.models.Pattern;
import com.catalog.catalogservice.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatternController {
    private EntryRepository entryRepository;

    @Autowired
    public PatternController(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @GetMapping("/patterns")
    List<Pattern> all() {
        return entryRepository.getAllPatterns();
    }
}
