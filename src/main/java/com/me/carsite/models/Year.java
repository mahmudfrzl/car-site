package com.me.carsite.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "year")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cars"})

public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date",nullable = false)
    private short date ;
    @OneToMany(mappedBy = "year")
    private List<Car> cars;
}
