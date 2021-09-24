package com.me.carsite.services.concrets;

import com.me.carsite.dtos.MarkaDto;
import com.me.carsite.models.Marka;
import com.me.carsite.repositories.MarkaRepo;
import com.me.carsite.services.abstracts.MarkaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MarkaManager implements MarkaService {
    private final MarkaRepo markaRepo;
    private final ModelMapper modelMapper;



    @Override
    public List<MarkaDto> getAll() {
        List<Marka> markaList = markaRepo.findAll();
        List<MarkaDto> resultDtos = markaList
                .stream()
                .map(marka -> modelMapper.map(marka, MarkaDto.class))
                .collect(Collectors.toList());
        return resultDtos;
    }
}
