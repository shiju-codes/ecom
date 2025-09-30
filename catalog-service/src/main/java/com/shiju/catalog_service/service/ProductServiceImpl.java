package com.shiju.catalog_service.service;

import com.shiju.catalog_service.entity.Product;
import com.shiju.catalog_service.exceptions.CatalogException;
import com.shiju.catalog_service.model.ProductRequest;
import com.shiju.catalog_service.repository.ProductRepository;
import com.shiju.catalog_service.utils.ProductHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
        List<Product> productEntities = ProductHelper.transformProductRequestToProductEntity(products);
        try {
            productRepository.saveAll(productEntities);
            return Boolean.TRUE;
        }catch (Exception e){
            log.error("0b2ea5fe-8675-4b92-812d-043ff088e231: Exception occurred while saving products : {}", e.getMessage());
            throw new CatalogException(e.getMessage(), e);
        }

    }
}
