package com.bradai.elasticsearch.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.bradai.elasticsearch.entity.City;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitySearchService {

    private final ElasticsearchClient elasticsearchClient;

    public CitySearchService(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    public List<City> searchCities(String prefix) throws IOException {
        SearchResponse<City> response = elasticsearchClient.search(s -> s
                        .index("cities")
                        .query(q -> q
                                .prefix(t -> t
                                        .field("city")
                                        .value(prefix.toLowerCase())
                                )
                        )
                        .size(10),
                City.class
        );

        return response.hits().hits()
                .stream()
                .map(hit -> new City(hit.id(), hit.source().getCity(),hit.source().getCountry(), hit.source().getFullName()))
                .collect(Collectors.toList());
    }
}
