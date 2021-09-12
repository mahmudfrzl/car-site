package com.me.carsite.controllers;

import com.me.carsite.services.abstracts.DistanceService;
import com.me.carsite.dtos.DistanceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/distance")
@RequiredArgsConstructor
public class DistanceController {
    private final DistanceService distanceService;

    @GetMapping("/getAll")
    public ResponseEntity<List<DistanceDto>>  getAll(){
        return ResponseEntity.ok(distanceService.getAll()) ;
    }
}
