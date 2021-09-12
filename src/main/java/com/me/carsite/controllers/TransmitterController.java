package com.me.carsite.controllers;

import com.me.carsite.dtos.TransmitterDto;
import com.me.carsite.services.abstracts.TransmitterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/transmitter")
@RequiredArgsConstructor
public class TransmitterController {
    private final TransmitterService transmitterService;

    @GetMapping("/getAll")
    public ResponseEntity<List<TransmitterDto>>  getAll() {
            return ResponseEntity.ok(transmitterService.getAll());
    }
}
