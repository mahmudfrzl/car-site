package com.me.carsite.services.concrets;

import com.me.carsite.dtos.TransmitterDto;
import com.me.carsite.models.Transmitter;
import com.me.carsite.repositories.TransmitterRepo;
import com.me.carsite.services.abstracts.TransmitterService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransmitterManager implements TransmitterService {
    private final TransmitterRepo transmitterRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<TransmitterDto> getAll() {
        List<Transmitter> transmitters = transmitterRepo.findAll();
        List<TransmitterDto> resultDtos = transmitters
                .stream()
                .map(transmitter -> modelMapper.map(transmitter,TransmitterDto.class))
                .collect(Collectors.toList());
        return resultDtos;
    }
}
