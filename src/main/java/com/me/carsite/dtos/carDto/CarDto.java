package com.me.carsite.dtos.carDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {

    private Long id;
    private Boolean carShowroom;
    private Boolean credit;
    private Boolean barter;
    private String carAbout;
    private BigDecimal price;
    private Long yearId;
    private Long markaId;
    private Long modelId;
    private Long gearTypeId;
    private Long fuelId;
    private Long distance;
    private Long cityId;
//    private Long photoId;
    private Long transmitterId;
    private Long colorId;
 }
