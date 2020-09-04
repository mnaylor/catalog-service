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
    String newPattern(@RequestBody Pattern pattern) {
        String createdPatternId = entryService.createPattern(pattern);
        return createdPatternId;
    }

}
