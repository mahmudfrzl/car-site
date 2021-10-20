package com.me.carsite.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car_advertisement")
@Entity
@Builder
public class CarAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "release_date")
    private LocalDate releaseDate = LocalDate.now();
    @Column(name = "explanation")
    private String explanation;

    @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name ="car_id", nullable = false)
    @ToString.Exclude
    private Car car;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id", nullable = false)
    @ToString.Exclude
    private Seller seller;

}
