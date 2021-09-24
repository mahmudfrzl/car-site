package com.me.carsite.services.concrets;

import com.me.carsite.dtos.ModelDto;
import com.me.carsite.models.Model;
import com.me.carsite.repositories.MarkaRepo;
import com.me.carsite.repositories.ModelRepo;
import com.me.carsite.services.abstracts.ModelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepo modelRepo;
    private final ModelMapper modelMapper;
    private final MarkaRepo markaRepo;




    @Override
    public List<ModelDto> getByMarkaId(Long markaId) {
        return modelRepo.getByMarkaId(markaId);
    }
}
