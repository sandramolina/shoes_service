package com.goldenshoe.ecommerceservice.repositories;

import com.goldenshoe.ecommerceservice.models.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecificationRepository extends JpaRepository<Specification, Long> {
}
