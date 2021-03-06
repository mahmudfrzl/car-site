package com.me.carsite.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fuel")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cars"})
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fuel_type",nullable = false)
    private String fuelType;

    @OneToMany(mappedBy = "fuel")
    private List<Car> cars;
}
