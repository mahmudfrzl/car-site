package com.me.carsite.services.abstracts;

import com.me.carsite.dtos.YearDto;

import java.util.List;

public interface YearService {
    List<YearDto>  getAll();
    YearDto save(YearDto yearDto);
    YearDto update(Long id,YearDto yearDto);

}
