package com.me.carsite.services.abstracts;

import com.me.carsite.dtos.CityDto;

import java.util.List;

public interface CityService {
    List<CityDto> getAll();
}
