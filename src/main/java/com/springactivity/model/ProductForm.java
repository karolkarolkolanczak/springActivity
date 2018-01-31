package com.springactivity.model;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

/**
 * Created by a on 26/01/2018.
 */
public class ProductForm {
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private MultipartFile file;
    private Byte[] image;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }
}
