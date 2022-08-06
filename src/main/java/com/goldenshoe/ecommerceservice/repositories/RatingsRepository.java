package com.goldenshoe.ecommerceservice.repositories;

import com.goldenshoe.ecommerceservice.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingsRepository extends JpaRepository<Rating, Long> {
}
