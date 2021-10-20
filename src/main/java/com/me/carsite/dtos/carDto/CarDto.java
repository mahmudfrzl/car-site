package com.me.carsite.dtos.carDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "Masinin ili secilmelidir")
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
