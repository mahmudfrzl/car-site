package com.me.carsite.services.abstracts;

import com.me.carsite.configurations.results.Result;
import com.me.carsite.dtos.carDto.CarAddDto;
import com.me.carsite.dtos.carDto.CarDto;

import java.util.List;

public interface CarService {
    Result saveCar(CarAddDto carDto);
   List<CarDto>  getAll();
   Boolean delete(Long id) throws Exception;
   CarDto getById(Long id) throws Exception;
}
