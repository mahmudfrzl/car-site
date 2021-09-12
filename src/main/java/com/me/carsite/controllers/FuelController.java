package com.me.carsite.controllers;

import com.me.carsite.services.abstracts.FuelService;
import com.me.carsite.dtos.FuelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fuel")
public class FuelController {
    private final FuelService fuelService;
    @GetMapping("/getAll")
    public ResponseEntity<List<FuelDto>>  getAll(){
        return ResponseEntity.ok(fuelService.getAll());
    }
}
