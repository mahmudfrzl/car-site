package com.me.carsite.repositories;

import com.me.carsite.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<Model,Long> {
}
