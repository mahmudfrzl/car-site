package com.me.carsite.services.concrets;

import com.me.carsite.configurations.results.DataResult;
import com.me.carsite.configurations.results.SuccessDataResult;
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
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarAdvertisementManager implements CarAdvertisementService {
    private final CarAdveritsementConverter carAdveritsementConverter;
    private final CarAdvertisementRepo carAdvertisementRepo;
    private final CarManager carManager;
    private final SellerManager sellerManager;


    @Transactional
    @Override
    public DataResult<CarAdvertisementAddDto> save(CarAdvertisementAddDto carAdvertisementAddDto) {
        Car car = carManager.getByCarId(carAdvertisementAddDto.getCarId());
        Seller seller = sellerManager.getBySellerId(carAdvertisementAddDto.getSellerId());

        CarAdvertisement carAdvertisement = new CarAdvertisement
                (
                carAdvertisementAddDto.getReleaseDate(),
                carAdvertisementAddDto.getExplanation(),
                car,
                seller
               );
            carAdvertisementAddDto= carAdveritsementConverter.convertToAddDto(carAdvertisementRepo.save(carAdvertisement));
        return new SuccessDataResult<CarAdvertisementAddDto>(
                carAdvertisementAddDto,
                "Car advertisement has been successfully created"
                , LocalDateTime.now(),
                HttpStatus.CREATED,
                HttpStatus.CREATED.value());
    }

    @Override
    public List<CarAdvertisementListDto> getAll() {
        return  carAdvertisementRepo.findAll()
                .stream().map(carAdveritsementConverter::convertToListDto)
                .collect(Collectors.toList());


    }

    @Override
    public CarAdvertisementListDto getById(Long id) {
        CarAdvertisement carAdvertisement = carAdvertisementRepo.findById(id).orElseThrow(
                () -> new CarAdvertisementNotFoundException("Advertisement can not find")
        );
        return carAdveritsementConverter.convertToListDto(carAdvertisement);
    }


}
//        List<CarAdvertisement> carAdvertisements = carAdvertisementRepo.findAll();
//        List<CarAdvertisementListDto> resultDtos = carAdvertisements.stream()
//                .map(carAdvertisement -> CarAdvertisementListDto.builder()
//                        .id(carAdvertisement.getId())
//                        .explanation(carAdvertisement.getExplanation())
//                        .releaseDate(carAdvertisement.getReleaseDate())
//                        .sellerId(carAdvertisement.getSeller().getId())
//                        .carId(carAdvertisement.getCar().getId()).build()).collect(Collectors.toList());
//        return resultDtos;

//    CarAdvertisement carAdvertisement = new CarAdvertisement(
//                carAdvertisementAddDto.getExplanation(),
//                carAdvertisementAddDto.getReleaseDate(),
//                carRepo.findById(carAdvertisementAddDto.getCarId()).get(),
//                sellerRepo.findById(carAdvertisementAddDto.getSellerId()).get()
//
//        );