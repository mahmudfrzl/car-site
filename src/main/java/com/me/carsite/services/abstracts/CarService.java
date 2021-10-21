package com.me.carsite.services.abstracts;

import com.me.carsite.configurations.results.Result;
import com.me.carsite.dtos.carDto.CarAddDto;
import com.me.carsite.dtos.carDto.CarDto;
import com.me.carsite.models.Car;

import java.util.List;

public interface CarService {
    CarAddDto saveCar(CarAddDto carDto);
   List<CarDto>  getAll();
   Boolean delete(Long id) throws Exception;
   CarDto getById(Long id) throws Exception;

}
