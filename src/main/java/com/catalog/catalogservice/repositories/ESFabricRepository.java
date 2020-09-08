package com.catalog.catalogservice.repositories;

import com.catalog.catalogservice.models.Fabric;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface ESFabricRepository extends ElasticsearchRepository<Fabric, String> {
    Page<Fabric> findAll();
    Page<Fabric> findAll(Pageable pageable);
    Optional<Fabric> findById(String id);
    Fabric save(Fabric fabric);
}
