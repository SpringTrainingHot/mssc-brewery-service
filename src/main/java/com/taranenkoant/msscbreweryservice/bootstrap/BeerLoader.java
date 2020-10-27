package com.taranenkoant.msscbreweryservice.bootstrap;

import com.taranenkoant.msscbreweryservice.domain.Beer;
import com.taranenkoant.msscbreweryservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
                    .beerName("Mongo Boobs")
                    .beerStyle("Ipa")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(337000000001L)
                    .price(new BigDecimal(12.95))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy cat")
                    .beerStyle("Pale Ale")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(337000000002L)
                    .price(new BigDecimal(11.95))
                    .build());
        }

        System.out.println("loaded Beers: " + beerRepository.count());
    }
}
