package com.me.carsite.controllers;

import com.me.carsite.dtos.MarkdaDto;
import com.me.carsite.services.abstracts.MarkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marka")
@RequiredArgsConstructor
public class MarkaController {
    private final MarkaService markaService;


    @GetMapping("getAll")
    public ResponseEntity<List<MarkdaDto>> getAll(){
        return ResponseEntity.ok(markaService.getAll());
    }
}
