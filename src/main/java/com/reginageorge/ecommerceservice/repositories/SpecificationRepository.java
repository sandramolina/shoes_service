package com.reginageorge.ecommerceservice.repositories;

import com.reginageorge.ecommerceservice.models.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecificationRepository extends JpaRepository<Specification, Long> {
}
