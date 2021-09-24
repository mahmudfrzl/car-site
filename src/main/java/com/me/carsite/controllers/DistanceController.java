package com.me.carsite.controllers;

import com.me.carsite.services.abstracts.DistanceService;
import com.me.carsite.dtos.DistanceDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distance")
@RequiredArgsConstructor
public class DistanceController {
    private final DistanceService distanceService;
    @PostMapping("/add")
    public  ResponseEntity<DistanceDto> add(@RequestBody DistanceDto distanceDto) {
        return ResponseEntity.ok(distanceService.add(distanceDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DistanceDto>>  getAll(){
        return ResponseEntity.ok(distanceService.getAll()) ;
    }
}
