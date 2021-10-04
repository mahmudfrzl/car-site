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
@Table(name = "color")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cars"})
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "color_type",nullable = false)
    private String colorType;

    @OneToMany(mappedBy = "color")
    private List<Car> cars;
}
