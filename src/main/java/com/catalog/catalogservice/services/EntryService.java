package com.catalog.catalogservice.services;

import com.catalog.catalogservice.models.Pattern;
import com.catalog.catalogservice.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
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

    public Pattern createPattern(Pattern pattern) {
        pattern.setLastModifiedInMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

        Pattern created = entryRepository.createPattern(pattern);

        return created;
    }

    public Pattern updatePattern(Pattern pattern) {
        pattern.setLastModifiedInMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

        Pattern updated = entryRepository.createPattern(pattern);

        return updated;
    }
}
