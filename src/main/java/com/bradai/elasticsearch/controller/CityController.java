package com.bradai.elasticsearch.controller;

import com.bradai.elasticsearch.entity.City;
import com.bradai.elasticsearch.service.CitySearchService;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/cities")
@CrossOrigin(origins = "*") // Allow Angular frontend to call
public class CityController {

    private final CitySearchService citySearchService;

    public CityController(CitySearchService citySearchService) {
        this.citySearchService = citySearchService;
    }

    @GetMapping("/search")
    public List<City> searchCities(@RequestParam String prefix) throws IOException {
        return citySearchService.searchCities(prefix);
    }
}

