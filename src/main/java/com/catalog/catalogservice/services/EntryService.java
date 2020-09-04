package com.catalog.catalogservice.services;

import com.catalog.catalogservice.models.Pattern;
import com.catalog.catalogservice.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntryService {
    private EntryRepository entryRepository;

    @Autowired
    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public List<Pattern> getAllPatterns() {
        return entryRepository.getAllPatterns();
    }

    public String createPattern(Pattern pattern) {
        String id = entryRepository.createPattern(pattern);

        return id;
    }
}
