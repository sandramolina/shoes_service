package com.goldenshoe.ecommerceservice.repositories;

import com.goldenshoe.ecommerceservice.models.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepository extends JpaRepository<ProductStock, Long> {
}
