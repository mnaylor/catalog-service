package com.catalog.catalogservice.repositories;

import com.catalog.catalogservice.exceptions.CatalogServiceException;
import com.catalog.catalogservice.models.EntryType;
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
    public Pattern getPatternById(String id) {
        Pattern pattern = null;
        try {
            pattern = patternRepository.findById(id);
        } catch (Exception ex) {
            throw new CatalogServiceException(CatalogServiceException.ServiceException.RepositoryException, ex);
        }

        if (pattern == null) {
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
            throw new CatalogServiceException(CatalogServiceException.ServiceException.RepositoryException);
        }

        return updatedPattern;
    }

    @Override
    public List<Fabric> getAllFabric() {
        return new ArrayList<Fabric>();
    }
}
