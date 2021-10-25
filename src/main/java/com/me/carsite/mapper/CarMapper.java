//package com.me.carsite.mapper;
//
//import com.me.carsite.dtos.carDto.CarAddDto;
//import com.me.carsite.models.Car;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//import org.mapstruct.factory.Mappers;
//
//@Mapper
//public interface CarMapper {
//    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
//    @Mappings({
//            @Mapping(target = "yearId",source = "car.year.id"),
//            @Mapping(target = "markaId",source = "car.marka.id"),
//            @Mapping(target = "modelId",source = "car.model.id"),
//            @Mapping(target = "gearTypeId",source = "car.gearType.id"),
//            @Mapping(target = "fuelId",source = "car.fuel.id"),
//            @Mapping(target = "cityId",source = "car.city.id"),
//            @Mapping(target = "transmitterId",source = "car.year.id"),
//            @Mapping(target = "colorId",source = "car.year.id"),
//    })
//    CarAddDto carToCarAddDto(Car Car);
//
//}
