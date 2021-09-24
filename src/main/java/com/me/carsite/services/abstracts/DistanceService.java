package com.me.carsite.services.abstracts;

import com.me.carsite.dtos.DistanceDto;

import java.util.List;

public interface DistanceService {
    List<DistanceDto> getAll();
    DistanceDto add(DistanceDto distanceDto);
}
