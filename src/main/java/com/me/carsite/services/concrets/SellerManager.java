package com.me.carsite.services.concrets;

import com.me.carsite.dtos.sellerDto.SellerAddDto;
import com.me.carsite.dtos.sellerDto.SellerListDto;
import com.me.carsite.exceptions.SellerNotFoundException;
import com.me.carsite.models.Seller;
import com.me.carsite.repositories.SellerRepo;
import com.me.carsite.services.abstracts.SellerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SellerManager implements SellerService {
    private final SellerRepo sellerRepo;
    private final ModelMapper modelMapper;
    @Override
    public SellerAddDto save(SellerAddDto sellerAddDto) {
        Seller seller = modelMapper.map(sellerAddDto,Seller.class);

        return modelMapper.map(sellerRepo.save(seller), SellerAddDto.class);
    }

    @Override
    public List<SellerListDto> getAll() {
        List<Seller> sellers = sellerRepo.findAll();
        List<SellerListDto> resultDtos  = sellers.stream()
                .map(seller -> modelMapper.map(seller,SellerListDto.class))
                .collect(Collectors.toList());
        return resultDtos;
    }

    protected Seller getBySellerId(Long id){
        Seller seller = sellerRepo.findById(id).orElseThrow(
                () -> new SellerNotFoundException("Seller Not Found")
        );
        return seller;
    }
}
