package com.me.carsite.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Long minAmountId;
    private Long maxAmountId;
    private Long gearTypeId;
    private Long fuelId;
    private Long distanceId;
    private Long cityId;
    private Long photoId;
    private Long transmitterId;
    private Long colorId;
 }
