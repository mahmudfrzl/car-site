package com.me.carsite.services.concrets;

import com.me.carsite.dtos.GearTypeDto;
import com.me.carsite.models.GearType;
import com.me.carsite.repositories.GearTypeRepo;
import com.me.carsite.services.abstracts.GearTypeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GearTypeManager implements GearTypeService {
    private final GearTypeRepo gearTypeRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<GearTypeDto> getAll() {
        List<GearType> gearTypes = gearTypeRepo.findAll();
        List<GearTypeDto> resultDtos = gearTypes
                .stream()
                .map(gearType -> modelMapper.map(gearType,GearTypeDto.class))
                .collect(Collectors.toList());
        return resultDtos;
    }
}
