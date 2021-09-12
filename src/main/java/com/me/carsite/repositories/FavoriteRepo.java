package com.me.carsite.repositories;

import com.me.carsite.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepo extends JpaRepository<Favorite,Long> {
}
