package com.me.carsite.controllers;

import com.me.carsite.dtos.GearTypeDto;
import com.me.carsite.services.abstracts.GearTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/geartype")
@RequiredArgsConstructor
public class GearTypeController {
    private final GearTypeService gearTypeService;

    @GetMapping("/getAll")
    public ResponseEntity<List<GearTypeDto>> getAll(){
        return ResponseEntity.ok(gearTypeService.getAll());
    }
}
