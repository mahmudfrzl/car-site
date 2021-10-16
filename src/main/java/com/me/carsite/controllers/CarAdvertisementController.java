package com.me.carsite.controllers;

import com.me.carsite.dto.CarAdvertisementAddDto;
import com.me.carsite.services.abstracts.CarAdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/caradvertisement")
@RequiredArgsConstructor
public class CarAdvertisementController {
    private final CarAdvertisementService carAdvertisementService;

    @PostMapping
    public ResponseEntity<CarAdvertisementAddDto>  save(@Valid @RequestBody CarAdvertisementAddDto carAdvertisementAddDto){
        return ResponseEntity.ok(carAdvertisementService.save(carAdvertisementAddDto));
    }
}
