package com.shiju.catalog_service.service.impl;

import com.shiju.catalog_service.entity.Product;
import com.shiju.catalog_service.exceptions.CatalogException;
import com.shiju.catalog_service.model.BrandResponse;
import com.shiju.catalog_service.model.ProductRequest;
import com.shiju.catalog_service.repository.ProductRepository;
import com.shiju.catalog_service.service.BrandService;
import com.shiju.catalog_service.service.ProductService;
import com.shiju.catalog_service.utils.ProductHelper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final BrandService brandService;

    public ProductServiceImpl(ProductRepository productRepository, BrandService brandService) {
        this.productRepository = productRepository;
        this.brandService = brandService;
    }


    /**
     * Service method to save products to db
     *
     * @param products
     * @return
     */
    @Override
    public Boolean addProducts(List<ProductRequest> products) {
        log.info("de750d1e-2ba1-4f72-813c-a3b4d634ce94: Request for saving products : {}", products);
        List<String> brandNames = products.stream().map(ProductRequest::brand).toList();
        List<BrandResponse> brands = brandService.getBrands(brandNames);
        List<Product> productEntities = ProductHelper.transformProductRequestToProductEntity(products, brands);
        try {
            productRepository.saveAll(productEntities);
            return Boolean.TRUE;
        }catch (Exception e){
            log.error("0b2ea5fe-8675-4b92-812d-043ff088e231: Exception occurred while saving products : {}", e.getMessage());
            throw new CatalogException(e.getMessage(), e);
        }

    }

}
