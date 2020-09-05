package com.catalog.catalogservice.repositories;

import com.catalog.catalogservice.models.Fabric;
import com.catalog.catalogservice.models.Pattern;

import java.util.List;

public interface EntryRepository {
    // Pattern
    public List<Pattern> getAllPatterns();
    public Pattern createPattern(Pattern pattern);
    public Pattern updatePattern(Pattern pattern);

    // Fabric
    public List<Fabric> getAllFabric();
}
