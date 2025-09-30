package com.shiju.catalog_service.controller;

import com.shiju.catalog_service.facade.ProductFacade;
import com.shiju.catalog_service.model.ProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Product controller to product manipulations
 */
@RestController
@RequestMapping("api/product")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductFacade productFacade;

    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    /**
     * Api to save list of products
     *
     * @param products
     * @return {@link Boolean}
     */
    @PostMapping
    public ResponseEntity<Boolean> addProducts(@RequestBody List<ProductRequest> products){
        log.info("dac1fed9-b184-4f02-8b8a-07cdb5f01c2e : Request received to add products : {}", products);
        return ResponseEntity.status(HttpStatus.CREATED).body(productFacade.addProducts(products));
    }

}
