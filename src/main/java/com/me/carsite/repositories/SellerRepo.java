package com.me.carsite.repositories;

import com.me.carsite.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Seller,Long> {
}
