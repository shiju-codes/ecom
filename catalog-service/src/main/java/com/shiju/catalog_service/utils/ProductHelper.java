package com.shiju.catalog_service.utils;

import com.shiju.catalog_service.entity.Brand;
import com.shiju.catalog_service.entity.Image;
import com.shiju.catalog_service.entity.Product;
import com.shiju.catalog_service.model.ProductRequest;

import java.util.ArrayList;
import java.util.List;

public class ProductHelper {

    public static List<Product> transformProductRequestToProductEntity(List<ProductRequest> productRequestList) {
        List<Product> productList = new ArrayList<>();
        productRequestList.forEach(productRequest -> {
            productList.add(transformProductRequestToProductEntity(productRequest));
        });
        return productList;
    }

    public static Product transformProductRequestToProductEntity(ProductRequest productRequest) {
        Brand brand = new Brand();
        brand.setName(productRequest.brand());
        List<Image> images = productRequest.images().stream().map(Image::new).toList();
        return Product.builder()
                .sku(productRequest.sku())
                .name(productRequest.name())
                .listPrice(productRequest.listPrice())
                .salePrice(productRequest.salePrice())
                .rating(productRequest.rating())
                .brand(brand)
                .images(images)
                .productUrl(productRequest.productUrl())
                .build();
    }
}
