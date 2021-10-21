package com.me.carsite.services.concrets;

import com.me.carsite.dtos.advertisementDto.CarAdvertisementAddDto;
import com.me.carsite.dtos.advertisementDto.CarAdvertisementListDto;
import com.me.carsite.dtos.converters.CarAdveritsementConverter;
import com.me.carsite.exceptions.CarAdvertisementNotFoundException;
import com.me.carsite.models.Car;
import com.me.carsite.models.CarAdvertisement;
import com.me.carsite.models.Seller;
import com.me.carsite.repositories.CarAdvertisementRepo;
import com.me.carsite.repositories.CarRepo;
import com.me.carsite.repositories.SellerRepo;
import com.me.carsite.services.abstracts.CarAdvertisementService;
import com.me.carsite.services.abstracts.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarAdvertisementManager implements CarAdvertisementService {
    private final CarRepo carRepo;
    private final SellerRepo sellerRepo;
    private final CarAdveritsementConverter carAdveritsementConverter;
    private final CarAdvertisementRepo carAdvertisementRepo;
    private final CarManager carManager;
    private final SellerManager sellerManager;


    @Transactional
    @Override
    public CarAdvertisementAddDto save(CarAdvertisementAddDto carAdvertisementAddDto) {
        Car car = carManager.getByCarId(carAdvertisementAddDto.getCarId());
        Seller seller = sellerManager.getBySellerId(carAdvertisementAddDto.getSellerId());

        CarAdvertisement carAdvertisement = new CarAdvertisement
                (
                carAdvertisementAddDto.getReleaseDate(),
                carAdvertisementAddDto.getExplanation(),
                car,
                seller
               );

        return carAdveritsementConverter.convertToAddDto(carAdvertisementRepo.save(carAdvertisement));
    }

    @Override
    public List<CarAdvertisementListDto> getAll() {
        return  carAdvertisementRepo.findAll()
                .stream().map(carAdveritsementConverter::convertToListDto)
                .collect(Collectors.toList());

//        List<CarAdvertisement> carAdvertisements = carAdvertisementRepo.findAll();
//        List<CarAdvertisementListDto> resultDtos = carAdvertisements.stream()
//                .map(carAdvertisement -> CarAdvertisementListDto.builder()
//                        .id(carAdvertisement.getId())
//                        .explanation(carAdvertisement.getExplanation())
//                        .releaseDate(carAdvertisement.getReleaseDate())
//                        .sellerId(carAdvertisement.getSeller().getId())
//                        .carId(carAdvertisement.getCar().getId()).build()).collect(Collectors.toList());
//        return resultDtos;
    }

    @Override
    public CarAdvertisementListDto getById(Long id) {
        Optional<CarAdvertisement> optionalCarAdvertisement = carAdvertisementRepo.findById(id);
        if (optionalCarAdvertisement.isPresent()) {
            return CarAdvertisementListDto.builder()
                    .id(optionalCarAdvertisement.get().getId())
                    .carId(optionalCarAdvertisement.get().getCar().getId())
                    .explanation(optionalCarAdvertisement.get().getExplanation())
                    .sellerId(optionalCarAdvertisement.get().getSeller().getId())
                    .releaseDate(optionalCarAdvertisement.get().getReleaseDate())
                    .build();
        }
        return null;//Throw add ele
    }


}


//    CarAdvertisement carAdvertisement = new CarAdvertisement(
//                carAdvertisementAddDto.getExplanation(),
//                carAdvertisementAddDto.getReleaseDate(),
//                carRepo.findById(carAdvertisementAddDto.getCarId()).get(),
//                sellerRepo.findById(carAdvertisementAddDto.getSellerId()).get()
//
//        );