package com.shiju.catalog_service.service;

import com.shiju.catalog_service.model.ProductRequest;

import java.util.List;

public interface ProductService {

    Boolean addProducts(List<ProductRequest> products);
}
