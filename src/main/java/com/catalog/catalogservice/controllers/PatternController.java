package com.catalog.catalogservice.controllers;

import com.catalog.catalogservice.models.Pattern;
import com.catalog.catalogservice.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatternController {
    private EntryService entryService;

    @Autowired
    public PatternController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("/patterns")
    List<Pattern> all() {
        return entryService.getAllPatterns();
    }

    @PostMapping("/pattern")
    Pattern newPattern(@RequestBody Pattern pattern) {
        Pattern createdPattern = entryService.createPattern(pattern);
        return createdPattern;
    }

    @PutMapping("/pattern/{id}")
    Pattern updatePattern(@RequestBody Pattern pattern) {
        Pattern updated = entryService.updatePattern(pattern);

        return updated;
    }
}
