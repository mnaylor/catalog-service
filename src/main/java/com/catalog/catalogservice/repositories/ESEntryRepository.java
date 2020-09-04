package com.catalog.catalogservice.repositories;

import com.catalog.catalogservice.models.Fabric;
import com.catalog.catalogservice.models.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class ESEntryRepository implements EntryRepository {
    private ESPatternRepository patternRepository;

    @Autowired
    public void setPatternRepository(ESPatternRepository esPatternRepository) {
        this.patternRepository = esPatternRepository;
    }

    @Override
    public List<Pattern> getAllPatterns() {
        Page<Pattern> page = patternRepository.findAll();

        return page.getContent();
    }

    @Override
    public String createPattern(Pattern pattern) {
        Pattern createdPattern = patternRepository.save(pattern);
        return createdPattern.getId();
    }

    @Override
    public List<Fabric> getAllFabric() {
        return new ArrayList<Fabric>();
    }
}
