package com.me.carsite.services.concrets;

import com.me.carsite.services.abstracts.CityService;
import com.me.carsite.dtos.CityDto;
import com.me.carsite.models.City;
import com.me.carsite.repositories.CityRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityManager implements CityService {
    private final CityRepo cityRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<CityDto>  getAll(){
        List<City> cities = cityRepo.findAll();
        List<CityDto> resultDtos = cities.stream().map(city -> modelMapper.map(city,CityDto.class)).collect(Collectors.toList());
        return resultDtos;
    }
}
