package com.me.carsite.repositories;

import com.me.carsite.models.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepo extends JpaRepository<Mobile,Long> {
}
