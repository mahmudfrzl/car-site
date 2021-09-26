package com.me.carsite.controllers;

import com.me.carsite.dtos.ColorDto;
import com.me.carsite.services.abstracts.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/colors")
@RequiredArgsConstructor
public class ColorController {
    private final ColorService colorService;


    @GetMapping("/getAll")
    public List<ColorDto> getAll() {
        return colorService.getAll();
    }
}
