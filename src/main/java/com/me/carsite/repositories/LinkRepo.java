package com.me.carsite.repositories;

import com.me.carsite.models.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepo extends JpaRepository<Link,Long> {
}
