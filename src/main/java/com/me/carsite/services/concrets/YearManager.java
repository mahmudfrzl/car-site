package com.me.carsite.services.concrets;

import com.me.carsite.dtos.YearDto;
import com.me.carsite.models.Year;
import com.me.carsite.repositories.YearRepo;
import com.me.carsite.services.abstracts.YearService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class YearManager implements YearService {
    private final YearRepo yearRepo;
    private final ModelMapper modelMapper;


    @Override
    public List<YearDto> getAll() {
        List<Year> years = yearRepo.findAll();
        List<YearDto> resultDtos =years.stream()
                .map(year -> modelMapper.map(year,YearDto.class))
                .collect(Collectors.toList());
        return resultDtos;
    }

    @Override
    public YearDto save(YearDto yearDto) {
        Year year = modelMapper.map(yearDto,Year.class);
        return modelMapper.map(yearRepo.save(year),YearDto.class);
    }

    @Override
    public YearDto update(Long id, YearDto yearDto) {
        Optional<Year> year = yearRepo.findById(id);
        if(year.isPresent()){
            year.get().setDate(yearDto.getDate());
            return modelMapper.map(yearRepo.save(year.get()),YearDto.class);
        }
        throw new IllegalArgumentException();
    }


}
