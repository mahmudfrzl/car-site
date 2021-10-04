package com.me.carsite.controllers;

import com.me.carsite.dtos.YearDto;
import com.me.carsite.services.abstracts.YearService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/years")
@RequiredArgsConstructor
public class YearController {
    private final YearService yearService;

    @GetMapping("/getAll")
    public ResponseEntity<List<YearDto>>  getAll() {
        return ResponseEntity.ok(yearService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<YearDto>  save(@Valid @RequestBody YearDto yearDto) {
        return ResponseEntity.ok(yearService.save(yearDto));
    }
    @PutMapping("/update")
    public ResponseEntity<YearDto> update(@Valid @RequestParam Long id,@Valid @RequestBody YearDto yearDto) {
        return ResponseEntity.ok(yearService.update(id,yearDto));
    }
}
