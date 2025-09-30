package com.shiju.catalog_service.utils;

import com.shiju.catalog_service.entity.Brand;
import com.shiju.catalog_service.entity.Image;
import com.shiju.catalog_service.entity.Product;
import com.shiju.catalog_service.model.BrandResponse;
import com.shiju.catalog_service.model.ProductRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductHelper {

    public static List<Product> transformProductRequestToProductEntity(List<ProductRequest> productRequestList, List<BrandResponse> brands) {
        List<Product> productList = new ArrayList<>();
        productRequestList.forEach(productRequest -> {
        Optional<BrandResponse> brand = brands.stream().filter(brandItem -> brandItem.name().equals(productRequest.brand())).findFirst();
            brand.ifPresent(brandResponse -> productList.add(transformProductRequestToProductEntity(productRequest, brandResponse)));
        });
        return productList;
    }

    public static Product transformProductRequestToProductEntity(ProductRequest productRequest, BrandResponse brand) {
        List<Image> images = productRequest.images().stream().map(Image::new).toList();
        return Product.builder()
                .sku(productRequest.sku())
                .name(productRequest.name())
                .listPrice(productRequest.listPrice())
                .salePrice(productRequest.salePrice())
                .rating(productRequest.rating())
                .brand(brand.name())
                .images(images)
                .productUrl(productRequest.productUrl())
                .build();
    }

}
