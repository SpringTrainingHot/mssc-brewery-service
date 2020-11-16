package com.taranenkoant.msscbreweryservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taranenkoant.msscbreweryservice.web.model.BeerDTO;
import com.taranenkoant.msscbreweryservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception{
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception{
        BeerDTO beerDTO = getValidBeerDto();
        String beerToJSon = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJSon))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception{
        BeerDTO beerDTO = getValidBeerDto();
        String beerToJSon = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJSon))
                .andExpect(status().isNoContent());
    }

    BeerDTO getValidBeerDto(){
        return BeerDTO.builder()
                .beerName("My beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("2.99"))
                .upc(12121212121212L)
                .build();
    }

    @Test
    void deleteBeerById() {
    }
}