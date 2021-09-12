package com.me.carsite.repositories;

import com.me.carsite.models.GearType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GearTypeRepo extends JpaRepository<GearType,Long> {
}
