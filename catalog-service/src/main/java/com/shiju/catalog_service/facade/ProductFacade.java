package com.shiju.catalog_service.facade;

import com.shiju.catalog_service.model.ProductRequest;

import java.util.List;

public interface ProductFacade {

    Boolean addProducts(List<ProductRequest> products);
}
