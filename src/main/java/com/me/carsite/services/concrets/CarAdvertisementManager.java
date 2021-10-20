package com.me.carsite.services.concrets;

import com.me.carsite.dtos.advertisementDto.CarAdvertisementAddDto;
import com.me.carsite.dtos.advertisementDto.CarAdvertisementListDto;
import com.me.carsite.dtos.converters.CarAdveritsementConverter;
import com.me.carsite.models.CarAdvertisement;
import com.me.carsite.repositories.CarAdvertisementRepo;
import com.me.carsite.repositories.CarRepo;
import com.me.carsite.repositories.SellerRepo;
import com.me.carsite.services.abstracts.CarAdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarAdvertisementManager implements CarAdvertisementService {
    private final CarRepo carRepo;
    private final SellerRepo sellerRepo;
    private final CarAdveritsementConverter carAdveritsementConverter;
    private final CarAdvertisementRepo carAdvertisementRepo;
    @Transactional
    @Override
    public CarAdvertisementAddDto save(CarAdvertisementAddDto carAdvertisementAddDto) {

        CarAdvertisement carAdvertisement = CarAdvertisement.builder()
                .car(carRepo.findById(carAdvertisementAddDto.getCarId()).get())
                .explanation(carAdvertisementAddDto.getExplanation())
                .releaseDate(carAdvertisementAddDto.getReleaseDate())
                .seller(sellerRepo.findById(carAdvertisementAddDto.getCarId()).get()).build();

        return carAdveritsementConverter.convert(carAdvertisementRepo.save(carAdvertisement) );
    }

    @Override
    public List<CarAdvertisementListDto> getAll() {
         List<CarAdvertisement> carAdvertisements = carAdvertisementRepo.findAll();
        List<CarAdvertisementListDto> resultDtos = carAdvertisements.stream()
                .map(carAdvertisement -> CarAdvertisementListDto.builder()
                        .id(carAdvertisement.getId())
                        .explanation(carAdvertisement.getExplanation())
                        .releaseDate(carAdvertisement.getReleaseDate())
                        .sellerId(carAdvertisement.getSeller().getId())
                        .carId(carAdvertisement.getCar().getId()).build()).collect(Collectors.toList());
        return resultDtos;
    }


}



//    CarAdvertisement carAdvertisement = new CarAdvertisement(
//                carAdvertisementAddDto.getExplanation(),
//                carAdvertisementAddDto.getReleaseDate(),
//                carRepo.findById(carAdvertisementAddDto.getCarId()).get(),
//                sellerRepo.findById(carAdvertisementAddDto.getSellerId()).get()
//
//        );