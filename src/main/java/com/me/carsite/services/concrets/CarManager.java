package com.me.carsite.services.concrets;

import com.me.carsite.configurations.results.Result;
import com.me.carsite.configurations.results.SuccessResult;
import com.me.carsite.dtos.carDto.CarAddDto;
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

    @Override
    public Result saveCar(CarAddDto carDto){
        Car car = modelMapper.map(carDto,Car.class);
        car.setCarAbout(carDto.getCarAbout());
        car.setCarShowroom(carDto.getCarShowroom());
        car.setBarter(carDto.getBarter());
        car.setCredit(carDto.getCredit());
        car.setPrice(carDto.getPrice());
        car.setDistance(carDto.getDistance());

//        Year year = new Year();
//        year.setId(carDto.getYearId());
//        car.setYear(year);
        car.setYear(yearRepo.findById(carDto.getYearId()).get());
//        Model model = new Model();
//        model.setId(carDto.getId());
//        car.setModel(model);

        car.setModel(modelRepo.findById(carDto.getModelId()).get());

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

//        car.setPhotos((List<Photo>) photoRepo.findById(carDto.getPhotoId()).get());
        modelMapper.map(carRepo.save(car),CarDto.class);
        return new SuccessResult("Success");

    }

    @Override
    public List<CarDto> getAll() {
        List<Car> cars = carRepo.findAll();
        List<CarDto> resultDtos = cars
                .stream()
                .map(car -> {
                    CarDto carDto = new CarDto();
                    carDto.setId(car.getId());
                    carDto.setCarShowroom(car.getCarShowroom());
                    carDto.setCarAbout(car.getCarAbout());
                    carDto.setBarter(car.getBarter());
                    carDto.setPrice(car.getPrice());
                    carDto.setCredit(car.getCredit());
                    carDto.setDistance(car.getDistance());
                    carDto.setCityId(car.getCity().getId());
                    carDto.setColorId( car.getColor().getId());
                    carDto.setFuelId( car.getFuel().getId());
                    carDto.setGearTypeId( car.getGearType().getId());
                    carDto.setMarkaId( car.getMarka().getId());
                    carDto.setModelId(car.getModel().getId());
                    carDto.setYearId(car.getYear().getId());
                    carDto.setTransmitterId( car.getTransmitter().getId());
                    return carDto;
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
        throw new Exception();
    }

    @Override
    public CarDto getById(Long id) throws Exception {//Exception Handler add ele
        Optional<Car> car = carRepo.findById(id);
        if(car.isPresent()){
            CarDto carDto = new CarDto();
            carDto.setId(car.get().getId());
            carDto.setCarShowroom(car.get().getCarShowroom());
            carDto.setYearId(car.get().getYear().getId());
            carDto.setCarAbout(car.get().getCarAbout());
            carDto.setBarter(car.get().getBarter());
            carDto.setPrice(car.get().getPrice());
            carDto.setCredit(car.get().getCredit());
            carDto.setDistance(car.get().getDistance());
            carDto.setCityId(car.get().getCity().getId());
            carDto.setColorId( car.get().getColor().getId());
            carDto.setFuelId( car.get().getFuel().getId());
            carDto.setGearTypeId( car.get().getGearType().getId());
            carDto.setMarkaId( car.get().getMarka().getId());
            carDto.setModelId(car.get().getModel().getId());
            carDto.setYearId(car.get().getYear().getId());
            carDto.setTransmitterId( car.get().getTransmitter().getId());
            return carDto;
        }
        throw new Exception();
    }
}
