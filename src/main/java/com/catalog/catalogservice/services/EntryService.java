package com.catalog.catalogservice.services;

import com.catalog.catalogservice.models.Fabric;
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

    public Pattern getPatternById(String id) {
        return entryRepository.getPatternById(id);
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
    
    // Fabric
    public List<Fabric> getAllFabrics() {
        return entryRepository.getAllFabrics();
    }

    public Fabric getFabricById(String id) {
        return entryRepository.getFabricById(id);
    }

    public Fabric createFabric(Fabric fabric) {
        fabric.setLastModifiedInMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

        Fabric created = entryRepository.createFabric(fabric);

        return created;
    }

    public Fabric updateFabric(Fabric fabric) {
        fabric.setLastModifiedInMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

        Fabric updated = entryRepository.createFabric(fabric);

        return updated;
    }
}
