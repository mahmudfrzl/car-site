package com.me.carsite.services.concrets;

import com.me.carsite.services.abstracts.DistanceService;
import com.me.carsite.dtos.DistanceDto;
import com.me.carsite.models.Distance;
import com.me.carsite.repositories.DistanceRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DistanceManager implements DistanceService {
    private final DistanceRepo distanceRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<DistanceDto> getAll(){
        List<Distance> distances = distanceRepo.findAll();
        List<DistanceDto> resultDtos = distances
                .stream()
                .map(distance -> modelMapper.map(distance,DistanceDto.class))
                .collect(Collectors.toList());
        return resultDtos;
    }

    @Override
    public DistanceDto add(DistanceDto distanceDto) {
        Distance distance = modelMapper.map(distanceDto,Distance.class);
        distance.setId(distanceDto.getId());
        distance.setKm(distanceDto.getKm());
        return modelMapper.map(distanceRepo.save(distance) ,DistanceDto.class);
    }
}
