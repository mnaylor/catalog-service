package com.catalog.catalogservice.repositories;

import com.catalog.catalogservice.models.Pattern;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface ESPatternRepository extends ElasticsearchRepository<Pattern, String> {
    Page<Pattern> findAll();
    Page<Pattern> findAll(Pageable pageable);
    Optional<Pattern> findById(String id);
    Pattern save(Pattern pattern);
}
