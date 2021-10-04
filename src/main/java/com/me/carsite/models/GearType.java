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
@Table(name = "gear_type")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cars"})
public class GearType {//mexanika,avtomat-suretler qutusu
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "type",nullable = false)
    private String type;

    @OneToMany(mappedBy = "gearType")
    private List<Car> cars;
}
