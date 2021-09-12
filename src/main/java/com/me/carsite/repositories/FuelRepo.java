package com.me.carsite.repositories;

import com.me.carsite.models.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRepo extends JpaRepository<Fuel,Long> {
}
