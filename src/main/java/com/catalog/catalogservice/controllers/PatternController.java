package com.catalog.catalogservice.controllers;

import com.catalog.catalogservice.models.Pattern;
import com.catalog.catalogservice.services.EntryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PatternController {
    private EntryService entryService;

    @Autowired
    public PatternController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("/patterns")
    List<Pattern> all() {
        List<Pattern> patterns = entryService.getAllPatterns();

        log.info("Found %s patterns", patterns.size());

        return patterns;
    }

    @GetMapping("/pattern/{id}")
    Pattern getPatternById(@PathVariable String id) {
        Pattern pattern = entryService.getPatternById(id);

        return pattern;
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
