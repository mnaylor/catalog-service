package com.catalog.catalogservice.repositories;

import com.catalog.catalogservice.models.Fabric;
import com.catalog.catalogservice.models.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
    public Pattern createPattern(Pattern pattern) {
        return updatePattern(pattern);
    }

    @Override
    public Pattern updatePattern(Pattern pattern) {
        Pattern updatedPattern = patternRepository.save(pattern);
        return updatedPattern;
    }

    @Override
    public List<Fabric> getAllFabric() {
        return new ArrayList<Fabric>();
    }
}
