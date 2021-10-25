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
@Table(name = "model")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cars"})
public class Model {//Astra
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;

    @ManyToOne
    @JoinColumn(name = "marka_id")
    private Marka marka;
}
