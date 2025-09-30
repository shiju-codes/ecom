package com.shiju.catalog_service.repository;

import com.shiju.catalog_service.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Optional<Brand> findByName(String name);

    Optional<List<Brand>> findByNameIn(List<String> name);
}
