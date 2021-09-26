package com.me.carsite.services.concrets;

import com.me.carsite.dtos.ColorDto;
import com.me.carsite.models.Color;
import com.me.carsite.repositories.ColorRepo;
import com.me.carsite.services.abstracts.ColorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColorManager implements ColorService {
    private final ModelMapper modelMapper;
    private final ColorRepo colorRepo;

    @Override
    public List<ColorDto>  getAll() {
        List<Color> colors = colorRepo.findAll();
        List<ColorDto> resultDtos = colors.stream()
                .map(color -> modelMapper.map(color,ColorDto.class))
                .collect(Collectors.toList());
        return resultDtos;
    }
}
