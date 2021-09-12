package com.me.carsite.repositories;

import com.me.carsite.models.MinAmount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinAmountRepo extends JpaRepository<MinAmount,Long> {
}
