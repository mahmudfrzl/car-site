package com.me.carsite.controllers;

import com.me.carsite.configurations.results.Result;
import com.me.carsite.dtos.carDto.CarAddDto;
import com.me.carsite.services.abstracts.CarService;
import com.me.carsite.dtos.carDto.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping("/save")
    public ResponseEntity<Result> saveCar(@Valid @RequestBody CarAddDto carDto){
        return ResponseEntity.ok(carService.saveCar(carDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CarDto>> getAll() {
        return ResponseEntity.ok(carService.getAll());
    }
    @DeleteMapping("/delete")
    public Boolean delete(@Valid @RequestParam Long id) throws Exception {
        return carService.delete(id);
    }
    @GetMapping("/getById")
    public ResponseEntity<CarDto> getById(@Valid @RequestParam  Long id) throws Exception {
        return ResponseEntity.ok(carService.getById(id));
    }

}
