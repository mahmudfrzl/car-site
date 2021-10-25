package com.me.carsite.dtos.carDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarAddDto {
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
