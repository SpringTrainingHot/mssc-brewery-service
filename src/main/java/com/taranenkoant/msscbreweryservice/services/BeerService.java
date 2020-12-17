package com.taranenkoant.msscbreweryservice.services;

import com.taranenkoant.msscbreweryservice.web.model.BeerDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService {
    BeerDTO getById(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO);
}
