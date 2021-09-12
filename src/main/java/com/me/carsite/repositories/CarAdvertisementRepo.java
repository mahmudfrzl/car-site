package com.me.carsite.repositories;

import com.me.carsite.models.CarAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarAdvertisementRepo extends JpaRepository<CarAdvertisement,Long> {
}
