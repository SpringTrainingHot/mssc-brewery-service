package com.taranenkoant.msscbreweryservice.web.mappers;

import com.taranenkoant.msscbreweryservice.domain.Beer;
import com.taranenkoant.msscbreweryservice.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDTO beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDTO dto);
}
