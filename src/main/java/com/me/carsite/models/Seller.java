package com.me.carsite.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seller")
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Seller extends User{


    @OneToMany(mappedBy = "seller")
    private List<CarAdvertisement> carAdvertisements;

    @OneToMany(mappedBy = "seller")
    private List<Mobile> mobiles;
}
