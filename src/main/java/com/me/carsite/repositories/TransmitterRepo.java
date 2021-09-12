package com.me.carsite.repositories;

import com.me.carsite.models.Transmitter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmitterRepo extends JpaRepository<Transmitter,Long> {
}
