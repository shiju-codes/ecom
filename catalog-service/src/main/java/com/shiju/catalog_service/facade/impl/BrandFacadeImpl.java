package com.shiju.catalog_service.facade.impl;

import com.shiju.catalog_service.facade.BrandFacade;
import com.shiju.catalog_service.service.BrandService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandFacadeImpl implements BrandFacade {

    private final BrandService brandService;

    public BrandFacadeImpl(BrandService brandService) {
        this.brandService = brandService;
    }

    @Override
    public Boolean addBrands(List<String> brands) {
        return brandService.addBrands(brands);
    }
}
