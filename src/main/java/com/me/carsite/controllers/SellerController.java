package com.me.carsite.controllers;

import com.me.carsite.dtos.sellerDto.SellerAddDto;
import com.me.carsite.dtos.sellerDto.SellerListDto;
import com.me.carsite.services.abstracts.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @PostMapping
    public ResponseEntity<SellerAddDto>  save(@Valid @RequestBody SellerAddDto sellerAddDto){
        return ResponseEntity.ok(sellerService.save(sellerAddDto));
    }
    @GetMapping
    public ResponseEntity<List<SellerListDto>>  getAll() {
        return ResponseEntity.ok(sellerService.getAll());
    }
}
