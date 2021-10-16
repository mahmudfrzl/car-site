package com.me.carsite.dtos.sellerDto;

import lombok.*;

import javax.persistence.Column;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerAddDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
