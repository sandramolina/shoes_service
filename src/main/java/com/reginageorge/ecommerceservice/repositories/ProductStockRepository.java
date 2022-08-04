package com.reginageorge.ecommerceservice.repositories;

import com.reginageorge.ecommerceservice.models.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepository extends JpaRepository<ProductStock, Long> {
}
