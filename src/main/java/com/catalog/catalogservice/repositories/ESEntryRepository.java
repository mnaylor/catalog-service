package com.catalog.catalogservice.repositories;

import com.catalog.catalogservice.exceptions.CatalogServiceException;
import com.catalog.catalogservice.models.Fabric;
import com.catalog.catalogservice.models.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ESEntryRepository implements EntryRepository {
    private ESPatternRepository patternRepository;
    private ESFabricRepository fabricRepository;

    @Autowired
    public void setPatternRepository(ESPatternRepository esPatternRepository) {
        this.patternRepository = esPatternRepository;
    }

    @Autowired
    public void setFabricRepository(ESFabricRepository esFabricRepository) {
        this.fabricRepository = esFabricRepository;
    }
    
    // Pattern

    @Override
    public List<Pattern> getAllPatterns() {
        Page<Pattern> page = patternRepository.findAll();

        return page.getContent();
    }

    @Override
    public Pattern getPatternById(String id) {
        Optional<Pattern> maybePattern = null;
        try {
            maybePattern = patternRepository.findById(id);
        } catch (Exception ex) {
            log.error(String.format("Failed to fetch pattern id=%s message=%s", id, ex.getMessage()));
            throw new CatalogServiceException(CatalogServiceException.ServiceException.RepositoryException, ex);
        }

        if (maybePattern.isEmpty()) {
            log.info(String.format("Pattern not found id=%s", id));
            throw new CatalogServiceException(CatalogServiceException.ServiceException.EntryNotFoundException);
        }

        return maybePattern.get();
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

    // Fabric
    
    @Override
    public List<Fabric> getAllFabrics() {
        Page<Fabric> fabric = fabricRepository.findAll();
        
        return fabric.getContent();
    }

    @Override
    public Fabric getFabricById(String id) {
        Optional<Fabric> maybeFabric;
        try {
            maybeFabric = fabricRepository.findById(id);
        } catch (Exception ex) {
            log.error(String.format("Failed to fetch fabric id=%s message=%s", id, ex.getMessage()));
            throw new CatalogServiceException(CatalogServiceException.ServiceException.RepositoryException, ex);
        }

        if (maybeFabric.isEmpty()) {
            log.info(String.format("Fabric not found id=%s", id));
            throw new CatalogServiceException(CatalogServiceException.ServiceException.EntryNotFoundException);
        }

        return maybeFabric.get();
    }

    @Override
    public Fabric createFabric(Fabric fabric) {
        return updateFabric(fabric);
    }

    @Override
    public Fabric updateFabric(Fabric fabric) {
        Fabric updatedFabric;

        try {
            updatedFabric = fabricRepository.save(fabric);
        } catch (Exception ex) {
            log.error(String.format("Failed to create or update fabric id=%s message=%s", fabric.getId(), ex.getMessage()));
            throw new CatalogServiceException(CatalogServiceException.ServiceException.RepositoryException);
        }

        return updatedFabric;
    }
}
