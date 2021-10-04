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
@Table(name = "marka")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cars"})

public class Marka {//Opel
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @OneToMany(mappedBy = "marka")
    private List<Car> cars;
    @OneToMany(mappedBy = "marka")
    private List<Model> models;
}
