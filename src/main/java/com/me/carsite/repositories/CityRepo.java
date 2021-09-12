package com.me.carsite.repositories;

import com.me.carsite.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City,Long> {
}
