package com.springactivity.model;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

/**
 * Created by a on 26/01/2018.
 */
public class ProductForm {
    private Long productFormId;
    private String name;
    private String description;
    private BigDecimal price;
    private MultipartFile file;

    public Long getProductFormId() {
        return productFormId;
    }

    public void setProductFormId(Long productFormId) {
        this.productFormId = productFormId;
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
}
