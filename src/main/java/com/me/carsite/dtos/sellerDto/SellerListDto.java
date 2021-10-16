package com.me.carsite.dtos.sellerDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerListDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
