package com.catalog.catalogservice.repositories;

import com.catalog.catalogservice.models.Pattern;
import com.catalog.catalogservice.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntryRepository {
    private EntryService entryService;

    @Autowired
    public EntryRepository(EntryService entryService) {
        this.entryService = entryService;
    }

    public List<Pattern> getAllPatterns() {
        return new ArrayList<Pattern>();
    }
}
