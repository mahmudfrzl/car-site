package com.me.carsite.repositories;

import com.me.carsite.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo,Long> {
    Photo findPhotoById(Long carId);
}
