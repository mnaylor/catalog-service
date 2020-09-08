package com.catalog.catalogservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName = "fabric-entry")
@TypeAlias("fabric")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Fabric {
    @Id
    private String id;
    private String name;
    private String source;
    private Double meterCount;
    private List<String> fabricContent;
    private String photoBucketLocation;
    private Long lastModifiedInMillis;
}
