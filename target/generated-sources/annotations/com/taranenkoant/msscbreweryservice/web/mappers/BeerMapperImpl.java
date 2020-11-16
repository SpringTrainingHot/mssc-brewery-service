package com.taranenkoant.msscbreweryservice.web.mappers;

import com.taranenkoant.msscbreweryservice.domain.Beer;
import com.taranenkoant.msscbreweryservice.domain.Beer.BeerBuilder;
import com.taranenkoant.msscbreweryservice.web.model.BeerDTO;
import com.taranenkoant.msscbreweryservice.web.model.BeerDTO.BeerDTOBuilder;
import com.taranenkoant.msscbreweryservice.web.model.BeerStyleEnum;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-16T18:25:12+0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDTO beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDTOBuilder beerDTO = BeerDTO.builder();

        beerDTO.id( beer.getId() );
        if ( beer.getVersion() != null ) {
            beerDTO.version( beer.getVersion().intValue() );
        }
        beerDTO.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDTO.lastModifiedDate( dateMapper.asOffsetDateTime( beer.getLastModifiedDate() ) );
        beerDTO.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDTO.beerStyle( Enum.valueOf( BeerStyleEnum.class, beer.getBeerStyle() ) );
        }
        beerDTO.upc( beer.getUpc() );
        beerDTO.price( beer.getPrice() );

        return beerDTO.build();
    }

    @Override
    public Beer beerDtoToBeer(BeerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BeerBuilder beer = Beer.builder();

        beer.id( dto.getId() );
        if ( dto.getVersion() != null ) {
            beer.version( dto.getVersion().longValue() );
        }
        beer.createdDate( dateMapper.asTimestamp( dto.getCreatedDate() ) );
        beer.lastModifiedDate( dateMapper.asTimestamp( dto.getLastModifiedDate() ) );
        beer.beerName( dto.getBeerName() );
        if ( dto.getBeerStyle() != null ) {
            beer.beerStyle( dto.getBeerStyle().name() );
        }
        beer.upc( dto.getUpc() );
        beer.price( dto.getPrice() );

        return beer.build();
    }
}
