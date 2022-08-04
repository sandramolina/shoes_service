package com.reginageorge.ecommerceservice.repositories;

import com.reginageorge.ecommerceservice.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizesRepository extends JpaRepository<Size, Long> {
}
