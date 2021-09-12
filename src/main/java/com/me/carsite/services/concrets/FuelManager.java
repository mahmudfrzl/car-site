package com.me.carsite.services.concrets;

import com.me.carsite.services.abstracts.FuelService;
import com.me.carsite.dtos.FuelDto;
import com.me.carsite.models.Fuel;
import com.me.carsite.repositories.FuelRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuelManager implements FuelService {
    private final ModelMapper modelMapper;
    private final FuelRepo fuelRepo;
    @Override
    public List<FuelDto> getAll(){
        List<Fuel> fuels = fuelRepo.findAll();
        List<FuelDto> resultDtos = fuels
                .stream()
                .map(fuel -> modelMapper.map(fuel,FuelDto.class))
                .collect(Collectors.toList());
        return resultDtos;
    }
}
