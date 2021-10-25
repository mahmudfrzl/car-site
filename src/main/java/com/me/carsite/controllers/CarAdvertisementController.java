package com.me.carsite.controllers;

import com.me.carsite.dtos.advertisementDto.CarAdvertisementAddDto;
import com.me.carsite.dtos.advertisementDto.CarAdvertisementListDto;
import com.me.carsite.services.abstracts.CarAdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/caradvertisement")
@RequiredArgsConstructor
public class CarAdvertisementController {
    private final CarAdvertisementService carAdvertisementService;

    @PostMapping("/save")
    public ResponseEntity<CarAdvertisementAddDto>  save(@Valid @RequestBody CarAdvertisementAddDto carAdvertisementAddDto){
        return ResponseEntity.ok(carAdvertisementService.save(carAdvertisementAddDto));
    }
    @GetMapping("/getAll")
    public  ResponseEntity<List<CarAdvertisementListDto>> getAll(){
        return ResponseEntity.ok(carAdvertisementService.getAll());
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<CarAdvertisementListDto>  getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(carAdvertisementService.getById(id));
    }
}
