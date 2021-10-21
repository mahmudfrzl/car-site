package com.me.carsite.dtos.converters;

import com.me.carsite.dtos.advertisementDto.CarAdvertisementAddDto;
import com.me.carsite.dtos.advertisementDto.CarAdvertisementListDto;
import com.me.carsite.models.CarAdvertisement;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CarAdveritsementConverter {
    public CarAdvertisementAddDto convertToAddDto(CarAdvertisement carAdvertisement){
        return CarAdvertisementAddDto.builder()
                .carId(carAdvertisement.getCar().getId())
                .explanation(carAdvertisement.getExplanation())
                .releaseDate(carAdvertisement.getReleaseDate())
                .sellerId(carAdvertisement.getSeller().getId()).build();
    }
    public CarAdvertisementListDto convertToListDto(CarAdvertisement carAdvertisement){
        return CarAdvertisementListDto.builder()
                .id(carAdvertisement.getId())
                .carId(carAdvertisement.getCar().getId())
                .explanation(carAdvertisement.getExplanation())
                .releaseDate(carAdvertisement.getReleaseDate())
                .sellerId(carAdvertisement.getSeller().getId()).build();
    }

}
