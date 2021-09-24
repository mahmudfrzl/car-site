package com.me.carsite.services.abstracts;

import com.me.carsite.dtos.ModelDto;

import java.util.List;

public interface ModelService {

    List<ModelDto> getByMarkaId(Long markaId);
}
