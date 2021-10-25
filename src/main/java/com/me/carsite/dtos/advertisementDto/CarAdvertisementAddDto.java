package com.me.carsite.dtos.advertisementDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.me.carsite.models.Car;
import com.me.carsite.models.Seller;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarAdvertisementAddDto {
    @JsonIgnore
    private LocalDate releaseDate = LocalDate.now();
    private String explanation;
    private Long carId;
    private Long sellerId;
}
