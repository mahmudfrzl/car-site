package com.me.carsite.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "car_showroom")
    private Boolean carShowroom;

    @Column(name = "credit")
    private Boolean credit;

    @Column(name = "barter")
    private Boolean barter;

    @Column(name = "car_about", nullable = false)
    private String carAbout;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="year_id", nullable = false)
    private Year year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "min_amount_id", nullable = false)
    private MinAmount minAmount;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "max_amount_id", nullable = false)
    private MaxAmount maxAmount;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marka_id", nullable = false)
    private Marka marka;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gear_type_id", nullable = false)
    private GearType gearType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fuel_id", nullable = false)
    private Fuel fuel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distance_id", nullable = false)
    private Distance distance;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transmitter_id", nullable = false)
    private Transmitter transmitter;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;


    @OneToMany(mappedBy = "car")
    private List<Photo> photos;

    @OneToOne(mappedBy = "car")
    private CarAdvertisement carAdvertisement;

}