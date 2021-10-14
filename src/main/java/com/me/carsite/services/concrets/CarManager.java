package com.me.carsite.services.concrets;

import com.me.carsite.configurations.results.Result;
import com.me.carsite.configurations.results.SuccessResult;
import com.me.carsite.dtos.carDto.CarAddDto;
import com.me.carsite.dtos.converters.CarDtoConverter;
import com.me.carsite.exceptions.CarNotFoundException;
import com.me.carsite.services.abstracts.CarService;
import com.me.carsite.dtos.carDto.CarDto;
import com.me.carsite.models.*;
import com.me.carsite.repositories.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarManager implements CarService {
    private final ModelMapper modelMapper;
    private final CarRepo carRepo;
    private final YearRepo yearRepo;
    private final ModelRepo modelRepo;
    private final MarkaRepo markaRepo;
    private final GearTypeRepo gearTypeRepo;
    private final FuelRepo fuelRepo;
    private final CityRepo cityRepo;
    private final PhotoRepo photoRepo;
    private final TransmitterRepo transmitterRepo;
    private final ColorRepo colorRepo;
    private final CarDtoConverter carDtoConverter;

    @Override
    public CarAddDto saveCar(CarAddDto carDto){
        Car car = new Car();
        car.setCarAbout(carDto.getCarAbout());
        car.setCarShowroom(carDto.getCarShowroom());
        car.setBarter(carDto.getBarter());
        car.setCredit(carDto.getCredit());
        car.setPrice(carDto.getPrice());
        car.setDistance(carDto.getDistance());
        car.setYear(yearRepo.findById(carDto.getYearId()).get());
        car.setModel(modelRepo.findById(carDto.getModelId()).get());
        car.setMarka(markaRepo.findById(carDto.getMarkaId()).get());
        car.setGearType(gearTypeRepo.findById(carDto.getGearTypeId()).get());
        car.setFuel(fuelRepo.findById(carDto.getFuelId()).get());
        car.setCity(cityRepo.findById(carDto.getCityId()).get());
        car.setTransmitter(transmitterRepo.findById(carDto.getTransmitterId()).get());
        car.setColor(colorRepo.findById(carDto.getColorId()).get());





//        car.setPhotos((List<Photo>) photoRepo.findById(carDto.getPhotoId()).get());

        return carDtoConverter.convert(carRepo.save(car));

    }

    @Override
    public List<CarDto> getAll() {
        List<Car> cars = carRepo.findAll();
        List<CarDto> resultDtos = cars
                .stream()
                .map(car -> {
                    return CarDto.builder()
                    .id(car.getId())
                    .carShowroom(car.getCarShowroom())
                    .carAbout(car.getCarAbout())
                    .barter(car.getBarter())
                    .price(car.getPrice())
                    .credit(car.getCredit())
                    .distance(car.getDistance())
                    .cityId(car.getCity().getId())
                    .colorId( car.getColor().getId())
                    .fuelId( car.getFuel().getId())
                    .gearTypeId( car.getGearType().getId())
                    .markaId( car.getMarka().getId())
                    .modelId(car.getModel().getId())
                    .yearId(car.getYear().getId())
                     .transmitterId( car.getTransmitter().getId()).build();
                })
                .collect(Collectors.toList());
        return resultDtos;
    }

    @Override
    public Boolean delete(Long id) throws Exception {//Exception Handler add ele
        Optional<Car> car = carRepo.findById(id);
        if(car.isPresent()){
            carRepo.deleteById(id);
            return true;
        }
        throw new CarNotFoundException("Car not found");
    }

    @Override
    public CarDto getById(Long id) throws Exception {//Exception Handler add ele
        Optional<Car> car = carRepo.findById(id);
        if(car.isPresent()){
            return CarDto.builder()
                    .id(car.get().getId())
                    .carShowroom(car.get().getCarShowroom())
                    .carAbout(car.get().getCarAbout())
                    .barter(car.get().getBarter())
                    .price(car.get().getPrice())
                    .credit(car.get().getCredit())
                    .distance(car.get().getDistance())
                    .cityId(car.get().getCity().getId())
                    .colorId( car.get().getColor().getId())
                    .fuelId( car.get().getFuel().getId())
                    .gearTypeId(car.get().getGearType().getId())
                    .markaId(car.get().getMarka().getId())
                    .modelId(car.get().getModel().getId())
                    .yearId(car.get().getYear().getId())
                    .transmitterId(car.get().getTransmitter().getId()).build();
        }
        throw new CarNotFoundException("Car Not Found");
    }
}




//        Year year = new Year();
//        year.setId(carDto.getYearId());
//        car.setYear(year);
//        Model model = new Model();
//        model.setId(carDto.getId());
//        car.setModel(model);
//Marka marka = new Marka();
//        marka.setId(carDto.getMarkaId());
//        car.setMarka(marka);
//
//        GearType gearType = new GearType();
//        gearType.setId(carDto.getGearTypeId());
//        car.setGearType(gearType);
//
//        Fuel fuel = new Fuel();
//        fuel.setId(carDto.getFuelId());
//        car.setFuel(fuel);
//
//
//
//        City city = new City();
//        city.setId(carDto.getCityId());
//        car.setCity(city);
//        Transmitter transmitter = new Transmitter();
//        transmitter.setId(carDto.getTransmitterId());
//        car.setTransmitter(transmitter);
//        Color color = new Color();
//        color.setId(carDto.getColorId());
//        car.setColor(color);
////        car.setPhotos((List<Photo>
