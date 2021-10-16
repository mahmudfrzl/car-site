package com.me.carsite.services.abstracts;

import com.me.carsite.dtos.advertisementDto.CarAdvertisementAddDto;
import com.me.carsite.dtos.advertisementDto.CarAdvertisementListDto;

import java.util.List;

public interface CarAdvertisementService {
    CarAdvertisementAddDto save(CarAdvertisementAddDto carAdvertisementAddDto);
    List<CarAdvertisementListDto> getAll();
}
