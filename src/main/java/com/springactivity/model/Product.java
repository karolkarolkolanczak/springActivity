package com.springactivity.model;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by a on 18/01/2018.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    as org.hibernate.dialect.Oracle10gDialect does not support identity key generation
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
//    @SequenceGenerator(name = "id_Sequence",sequenceName = "ID_SEQ")
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private String fotoImageUrl;
    @Lob
    private Byte[] image;
    @Transient
    private MultipartFile file;
    // not mapping below
//    private List<ProductCategory> productCategoryList=new ArrayList<>();

    public Product() {
    }

    public Product(String name, String description, BigDecimal price, String fotoImageUrl, Byte[] image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.fotoImageUrl = fotoImageUrl;
        this.image = image;
    }

    public Product(Long productId, String name, String description, BigDecimal price, Byte[] image) {
        this.productId=productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
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

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
