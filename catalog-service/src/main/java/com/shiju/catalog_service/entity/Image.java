package com.shiju.catalog_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "ecom_image")
@Data
public class Image {

    public Image(String url){
        this.url = url;
    }

    public Image(){

    }

    @Id
    private Long id;

    private String url;

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
