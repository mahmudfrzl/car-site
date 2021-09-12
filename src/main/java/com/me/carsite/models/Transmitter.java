package com.me.carsite.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transmitter")
@Entity
public class Transmitter {//ötürücü-arxa ön
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "transmitter_type",nullable = false)
    private String transmitterType;

    @OneToMany(mappedBy = "transmitter")
    private List<Car> cars;
}
