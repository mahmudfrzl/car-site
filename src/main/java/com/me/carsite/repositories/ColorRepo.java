package com.me.carsite.repositories;

import com.me.carsite.models.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepo  extends JpaRepository<Color,Long> {
}
