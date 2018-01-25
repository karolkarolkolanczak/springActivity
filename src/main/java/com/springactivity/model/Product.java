package com.springactivity.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
/**
 * Created by a on 18/01/2018.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private String fotoImageUrl;
    // not mapping below
//    private List<ProductCategory> productCategoryList=new ArrayList<>();

    public Product() {
    }

    public Product(Long productId, String name, String description, BigDecimal price, String fotoImageUrl) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.fotoImageUrl = fotoImageUrl;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal  getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFotoImageUrl() {
        return fotoImageUrl;
    }

    public void setFotoImageUrl(String fotoImageUrl) {
        this.fotoImageUrl = fotoImageUrl;
    }
}
