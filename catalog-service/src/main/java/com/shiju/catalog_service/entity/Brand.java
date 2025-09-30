package com.shiju.catalog_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ecom_brand")
@Data
public class Brand {

    @Id
    private Long id;

    private String name;

}
