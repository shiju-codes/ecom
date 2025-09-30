package com.shiju.catalog_service.service;

import com.shiju.catalog_service.model.BrandResponse;

import java.util.List;

public interface BrandService {

    Boolean addBrands(List<String> brands);

    List<BrandResponse> getBrands(List<String> brands);
}
