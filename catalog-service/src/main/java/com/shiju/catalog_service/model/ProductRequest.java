package com.shiju.catalog_service.model;

import com.shiju.catalog_service.entity.Brand;
import com.shiju.catalog_service.entity.Image;

import java.math.BigDecimal;
import java.util.List;

public record ProductRequest(Long sku, String name, BigDecimal listPrice, BigDecimal salePrice, float rating,
                             String brand, String productUrl, List<String> images) {}
