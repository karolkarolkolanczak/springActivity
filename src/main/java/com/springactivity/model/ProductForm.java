package com.springactivity.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by a on 26/01/2018.
 */
public class ProductForm {
    private Long productId;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String description;
    @NotNull
    @Digits(integer =5, fraction =2)
    private BigDecimal price;
    private MultipartFile file;
    private Byte[] image;
    private boolean dataProductFromDatabase;
    private ProductCategory productCategory;
    private List<ProductCategory> productCategoryList;

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

    public boolean isDataProductFromDatabase() {
        return dataProductFromDatabase;
    }

    public void setDataProductFromDatabase(boolean dataProductFromDatabase) {
        this.dataProductFromDatabase = dataProductFromDatabase;
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
