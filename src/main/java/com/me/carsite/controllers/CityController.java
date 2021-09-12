package com.me.carsite.controllers;

import com.me.carsite.services.abstracts.CityService;
import com.me.carsite.dtos.CityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CityDto>> getAll(){
        return ResponseEntity.ok(cityService.getAll());
    }


}
