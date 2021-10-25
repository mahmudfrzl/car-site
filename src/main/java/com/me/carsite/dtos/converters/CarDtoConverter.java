package com.me.carsite.dtos.converters;

import com.me.carsite.dtos.carDto.CarAddDto;
import com.me.carsite.dtos.carDto.CarDto;
import com.me.carsite.models.Car;
import org.springframework.stereotype.Component;

@Component
public class CarDtoConverter {

    public CarAddDto convert(Car car){
        return CarAddDto.builder()
                .carAbout(car.getCarAbout())
                .carShowroom(car.getCarShowroom())
                .barter(car.getBarter())
                .cityId(car.getCity().getId())
                .credit(car.getCredit())
                .colorId(car.getColor().getId())
                .distance(car.getDistance())
                .fuelId(car.getFuel().getId())
                .gearTypeId(car.getGearType().getId())
                .markaId(car.getMarka().getId())
                .modelId(car.getModel().getId())
                .price(car.getPrice())
                .transmitterId(car.getTransmitter().getId())
                .yearId(car.getYear().getId()).build();

    }
    public CarDto convertToListDto(Car car){
        return CarDto.builder()
                .id(car.getId())
                .carAbout(car.getCarAbout())
                .carShowroom(car.getCarShowroom())
                .barter(car.getBarter())
                .cityId(car.getCity().getId())
                .credit(car.getCredit())
                .colorId(car.getColor().getId())
                .distance(car.getDistance())
                .fuelId(car.getFuel().getId())
                .gearTypeId(car.getGearType().getId())
                .markaId(car.getMarka().getId())
                .modelId(car.getModel().getId())
                .price(car.getPrice())
                .transmitterId(car.getTransmitter().getId())
                .yearId(car.getYear().getId()).build();

    }
}
