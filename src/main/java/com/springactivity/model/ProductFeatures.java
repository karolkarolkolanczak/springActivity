package com.springactivity.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by a on 07/02/2018.
 */
@Entity
public class ProductFeatures {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productFeaturesId;
    private String color;
    private String material;
    private BigDecimal weight;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    // Attribute mappedBy indicates that the entity in this side is the inverse of the relationship,
    // and the owner resides in the “other” entity.
    @OneToOne(mappedBy = "productFeatures",cascade = CascadeType.ALL)
    private Product product;

    public Long getProductFeaturesId() {
        return productFeaturesId;
    }

    public void setProductFeaturesId(Long productFeaturesId) {
        this.productFeaturesId = productFeaturesId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
