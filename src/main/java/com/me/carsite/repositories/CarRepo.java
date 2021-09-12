package com.me.carsite.repositories;

import com.me.carsite.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,Long> {
}
