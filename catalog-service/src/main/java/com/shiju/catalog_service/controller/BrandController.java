package com.shiju.catalog_service.controller;

import com.shiju.catalog_service.facade.BrandFacade;
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

@RestController
@RequestMapping("/api/brand")
public class BrandController {

    private static final Logger log = LoggerFactory.getLogger(BrandController.class);

    private final BrandFacade brandFacade;

    public BrandController(BrandFacade brandFacade) {
        this.brandFacade = brandFacade;
    }

    @PostMapping()
    public ResponseEntity<Boolean> addBrands(@RequestBody List<String> brands){
      log.info("eb715f5f-543c-419d-a92a-1f29088d47ba: Request received to add brands : {}", brands);
      return ResponseEntity.status(HttpStatus.CREATED).body(brandFacade.addBrands(brands));
    }

}
