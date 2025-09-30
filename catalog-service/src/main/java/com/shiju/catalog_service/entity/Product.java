package com.shiju.catalog_service.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ecom_product")
@Data
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sku;

    private String name;

    private BigDecimal listPrice;

    private BigDecimal salePrice;

    private float rating;

    @OneToOne(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private Brand brand;

    private String productUrl;

    @OneToMany(mappedBy = "ecom_image", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    @Version
    private Long version;

    private Date created;

    private Date updated;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

}
