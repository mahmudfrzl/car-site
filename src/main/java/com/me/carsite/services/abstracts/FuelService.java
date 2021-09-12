package com.me.carsite.services.abstracts;

import com.me.carsite.dtos.FuelDto;

import java.util.List;

public interface FuelService {
    List<FuelDto> getAll();
}
