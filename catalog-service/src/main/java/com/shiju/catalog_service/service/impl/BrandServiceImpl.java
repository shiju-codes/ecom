package com.shiju.catalog_service.service.impl;

import com.shiju.catalog_service.entity.Brand;
import com.shiju.catalog_service.exceptions.CatalogException;
import com.shiju.catalog_service.model.BrandResponse;
import com.shiju.catalog_service.repository.BrandRepository;
import com.shiju.catalog_service.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Boolean addBrands(List<String> brands) {
        log.info("35ba3ae9-0375-4bfc-83df-1c11528af4e3: Request to add brands : {}", brands);
        List<Brand> brandsEntities = brands.stream().map(Brand::new).toList();
        try {
            brandRepository.saveAll(brandsEntities);
            return true;
        } catch (Exception e) {
            throw new CatalogException(e.getMessage(), e);
        }
    }

    public List<BrandResponse> getBrands(List<String> brands){
        if (CollectionUtils.isEmpty(brands)){
            return Collections.emptyList();
        }
        return brandRepository.findByNameIn(brands).
                orElse(Collections.emptyList())
                .stream().map(brand -> new BrandResponse(brand.getName(),brand.getId())).toList();
    }
}
