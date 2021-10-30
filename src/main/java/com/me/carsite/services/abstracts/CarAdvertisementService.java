package com.me.carsite.services.abstracts;

import com.me.carsite.configurations.results.DataResult;
import com.me.carsite.dtos.advertisementDto.CarAdvertisementAddDto;
import com.me.carsite.dtos.advertisementDto.CarAdvertisementListDto;

import java.util.List;

public interface CarAdvertisementService {
   DataResult<CarAdvertisementAddDto>  save(CarAdvertisementAddDto carAdvertisementAddDto);
    List<CarAdvertisementListDto> getAll();
    CarAdvertisementListDto getById(Long id);
}
