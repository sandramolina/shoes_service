package com.goldenshoe.ecommerceservice.repositories;

import com.goldenshoe.ecommerceservice.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizesRepository extends JpaRepository<Size, Long> {
}
