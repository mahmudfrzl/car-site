package com.me.carsite.services.abstracts;

import com.me.carsite.dtos.sellerDto.SellerAddDto;
import com.me.carsite.dtos.sellerDto.SellerListDto;

import java.util.List;

public interface SellerService {
    SellerAddDto save(SellerAddDto sellerAddDto);
    List<SellerListDto> getAll();
}
