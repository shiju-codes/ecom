package com.shiju.catalog_service.facade;

import com.shiju.catalog_service.model.ProductRequest;
import com.shiju.catalog_service.service.ProductService;
import com.shiju.catalog_service.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ProductFacadeImpl implements ProductFacade {

    private final ProductService productService;

    public ProductFacadeImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Boolean addProducts(List<ProductRequest> products) {
        log.info("724b0d0c-c2ae-4a75-8660-675fae2aa8f8: Request for saving products : {}", products);
        return productService.addProducts(products);
    }
}
