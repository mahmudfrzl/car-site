package com.me.carsite.services.concrets;

import com.me.carsite.services.abstracts.CarService;
import com.me.carsite.dtos.CarDto;
import com.me.carsite.models.*;
import com.me.carsite.repositories.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Override
    public CarDto saveCar(CarDto carDto){
        Car car = modelMapper.map(carDto,Car.class);
        car.setCarAbout(carDto.getCarAbout());
        car.setCarShowroom(carDto.getCarShowroom());
        car.setBarter(carDto.getBarter());
        car.setCredit(carDto.getCredit());
        car.setPrice(carDto.getPrice());
        Year year = new Year();
        year.setId(carDto.getYearId());
        car.setYear(year);

        Model model = new Model();
        model.setId(carDto.getId());
        car.setModel(model);


        Marka marka = new Marka();
        marka.setId(carDto.getMarkaId());
        car.setMarka(marka);

        GearType gearType = new GearType();
        gearType.setId(carDto.getGearTypeId());
        car.setGearType(gearType);

        Fuel fuel = new Fuel();
        fuel.setId(carDto.getFuelId());
        car.setFuel(fuel);


        City city = new City();
        city.setId(carDto.getCityId());
        car.setCity(city);

        Transmitter transmitter = new Transmitter();
        transmitter.setId(carDto.getTransmitterId());
        car.setTransmitter(transmitter);

        Color color = new Color();
        color.setId(carDto.getColorId());
        car.setColor(color);

        car.setPhotos((List<Photo>) photoRepo.findById(carDto.getPhotoId()).get());

        return modelMapper.map(carRepo.save(car),CarDto.class);

    }
}
