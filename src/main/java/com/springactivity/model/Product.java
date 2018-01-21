package com.springactivity.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 18/01/2018.
 */
public class Product {
    private Integer productId;
    private String name;
    private String description;
    private double price;
    private String fotoImageUrl;
    private List<ProductCategory> productCategoryList=new ArrayList<>();

    public Product() {
    }

    public Product(Integer productId, String name, String description, double price, String fotoImageUrl) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.fotoImageUrl = fotoImageUrl;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFotoImageUrl() {
        return fotoImageUrl;
    }

    public void setFotoImageUrl(String fotoImageUrl) {
        this.fotoImageUrl = fotoImageUrl;
    }
}
