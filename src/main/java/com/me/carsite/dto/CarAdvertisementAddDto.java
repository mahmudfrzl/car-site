package com.me.carsite.dto;

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
    private LocalDate releaseDate;
    private String explanation;
    private Long carId;
    private Long sellerId;
}
