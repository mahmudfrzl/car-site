package com.me.carsite.dtos.advertisementDto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarAdvertisementListDto {
    private Long id;
    private LocalDate releaseDate = LocalDate.now();
    private String explanation;
    private Long carId;
    private Long sellerId;
}
