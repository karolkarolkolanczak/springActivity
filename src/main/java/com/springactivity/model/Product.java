package com.springactivity.model;

/**
 * Created by a on 18/01/2018.
 */
public class Product {
    int productId;
    String productName;
    String description;
    double price;
    String fotoImageUrl;


    public Product() {
    }

    public Product(int productId, String productName, String description, double price, String fotoImageUrl) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.fotoImageUrl = fotoImageUrl;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
