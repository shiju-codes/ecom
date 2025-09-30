package com.shiju.catalog_service.repository;

import com.shiju.catalog_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
