package com.catalog.catalogservice.repositories;

import com.catalog.catalogservice.exceptions.CatalogServiceException;
import com.catalog.catalogservice.models.Fabric;
import com.catalog.catalogservice.models.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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
    public Pattern getPatternById(String id) {
        Pattern pattern = null;
        try {
            pattern = patternRepository.findById(id);
        } catch (Exception ex) {
            log.error(String.format("Failed to fetch pattern id=%s message=%s", id, ex.getMessage()));
            throw new CatalogServiceException(CatalogServiceException.ServiceException.RepositoryException, ex);
        }

        if (pattern == null) {
            log.info(String.format("Pattern not found id=%s", id));
            throw new CatalogServiceException(CatalogServiceException.ServiceException.EntryNotFoundException);
        }

        return pattern;
    }

    @Override
    public Pattern createPattern(Pattern pattern) {
        return updatePattern(pattern);
    }

    @Override
    public Pattern updatePattern(Pattern pattern) {
        Pattern updatedPattern;

        try {
            updatedPattern = patternRepository.save(pattern);
        } catch (Exception ex) {
            log.error(String.format("Failed to create or update pattern id=%s message=%s", pattern.getId(), ex.getMessage()));
            throw new CatalogServiceException(CatalogServiceException.ServiceException.RepositoryException);
        }

        return updatedPattern;
    }

    @Override
    public List<Fabric> getAllFabric() {
        return new ArrayList<Fabric>();
    }
}
