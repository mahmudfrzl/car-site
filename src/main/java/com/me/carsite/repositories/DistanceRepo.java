package com.me.carsite.repositories;

import com.me.carsite.models.Distance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistanceRepo extends JpaRepository<Distance,Long> {
}
