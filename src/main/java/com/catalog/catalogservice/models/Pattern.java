package com.catalog.catalogservice.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName = "catalog")
@TypeAlias("pattern")
@Data
public class Pattern {
    @Id
    private String id;
    private String name;
    private String source;
    private List<String> patternType;
    private List<String> tags;
    private String photoBucketLocation;
}
