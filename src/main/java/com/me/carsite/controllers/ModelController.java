package com.me.carsite.controllers;

import com.me.carsite.dtos.ModelDto;
import com.me.carsite.models.Model;
import com.me.carsite.services.abstracts.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
@RequiredArgsConstructor
public class ModelController {
    private final ModelService modelService;

    @GetMapping("/getByMarkaId")
    public List<ModelDto> getByMarkaId(@RequestParam Long markaId) {
        return modelService.getByMarkaId( markaId);
    }

}
