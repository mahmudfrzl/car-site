package com.me.carsite.repositories;

import com.me.carsite.models.Year;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearRepo extends JpaRepository<Year,Long> {
}
