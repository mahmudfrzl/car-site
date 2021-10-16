package com.me.carsite.dtos.converters;

import com.me.carsite.dto.CarAdvertisementAddDto;
import com.me.carsite.models.CarAdvertisement;
import org.springframework.stereotype.Component;

@Component
public class CarAdveritsementConverter {
    public CarAdvertisementAddDto convert(CarAdvertisement carAdvertisement){
        return CarAdvertisementAddDto.builder()
                .carId(carAdvertisement.getCar().getId())
                .explanation(carAdvertisement.getExplanation())
                .releaseDate(carAdvertisement.getReleaseDate())
                .sellerId(carAdvertisement.getSeller().getId()).build();
    }
}
