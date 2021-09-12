package com.me.carsite.controllers;

import com.me.carsite.services.abstracts.LinkService;
import com.me.carsite.dtos.LinkAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;

    @PostMapping("/add")
    public ResponseEntity<LinkAddDto> addLink(@RequestBody LinkAddDto linkAddDto){
        return ResponseEntity.ok(linkService.addLink(linkAddDto));
    }
}
