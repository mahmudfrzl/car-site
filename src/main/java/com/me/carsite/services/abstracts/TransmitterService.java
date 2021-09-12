package com.me.carsite.services.abstracts;

import com.me.carsite.dtos.TransmitterDto;

import java.util.List;

public interface TransmitterService {
    List<TransmitterDto> getAll();
}
