package com.me.carsite.controllers;

import com.me.carsite.services.abstracts.CarService;
import com.me.carsite.dtos.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping("/save")
    public ResponseEntity<CarDto> saveCar(@RequestBody CarDto carDto){
        return ResponseEntity.ok(carService.saveCar(carDto));
    }

}
