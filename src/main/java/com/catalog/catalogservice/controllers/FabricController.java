package com.catalog.catalogservice.controllers;

import com.catalog.catalogservice.models.Fabric;
import com.catalog.catalogservice.services.EntryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class FabricController {
    private EntryService entryService;

    @Autowired
    public FabricController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("/fabrics")
    List<Fabric> all() {
        List<Fabric> fabrics = entryService.getAllFabrics();

        log.info(String.format("Found %s fabrics", fabrics.size()));

        return fabrics;
    }

    @GetMapping("/fabric/{id}")
    Fabric getFabricById(@PathVariable String id) {
        Fabric fabric = entryService.getFabricById(id);

        return fabric;
    }

    @PostMapping("/fabric")
    Fabric newFabric(@RequestBody Fabric fabric) {
        Fabric createdFabric = entryService.createFabric(fabric);
        return createdFabric;
    }

    @PutMapping("/fabric/{id}")
    Fabric updateFabric(@RequestBody Fabric fabric) {
        Fabric updated = entryService.updateFabric(fabric);

        return updated;
    }
}
