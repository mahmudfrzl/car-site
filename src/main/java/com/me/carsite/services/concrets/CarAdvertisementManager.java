package com.me.carsite.services.concrets;

import com.me.carsite.dto.CarAdvertisementAddDto;
import com.me.carsite.dtos.converters.CarAdveritsementConverter;
import com.me.carsite.models.CarAdvertisement;
import com.me.carsite.repositories.CarAdvertisementRepo;
import com.me.carsite.repositories.CarRepo;
import com.me.carsite.repositories.SellerRepo;
import com.me.carsite.services.abstracts.CarAdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarAdvertisementManager implements CarAdvertisementService {
    private final CarRepo carRepo;
    private final SellerRepo sellerRepo;
    private final CarAdveritsementConverter carAdveritsementConverter;
    private final CarAdvertisementRepo carAdvertisementRepo;
    @Override
    public CarAdvertisementAddDto save(CarAdvertisementAddDto carAdvertisementAddDto) {
        CarAdvertisement carAdvertisement = CarAdvertisement.builder()
                .car(carRepo.findById(carAdvertisementAddDto.getCarId()).get())
                .explanation(carAdvertisementAddDto.getExplanation())
                .releaseDate(carAdvertisementAddDto.getReleaseDate())
                .seller(sellerRepo.findById(carAdvertisementAddDto.getCarId()).get()).build();

        return carAdveritsementConverter.convert(carAdvertisementRepo.save(carAdvertisement) );
    }
}
