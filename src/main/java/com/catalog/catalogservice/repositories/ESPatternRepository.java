package com.catalog.catalogservice.repositories;

import com.catalog.catalogservice.models.Pattern;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface ESPatternRepository extends Repository<Pattern, String> {
    Page<Pattern> findAll();
    Page<Pattern> findAll(Pageable pageable);
    Pattern save(Pattern pattern);
}
