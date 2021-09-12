package com.me.carsite.repositories;

import com.me.carsite.models.Marka;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkaRepo extends JpaRepository<Marka,Long> {
}
