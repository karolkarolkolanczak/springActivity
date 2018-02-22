package com.springactivity.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by a on 21/02/2018.
 */
public class ProductCategoryTest {

    ProductCategory productCategory;

    @Before
    public void setUp() throws Exception {
        productCategory=new ProductCategory();
    }


    @Test
    public void getProductCategoryId() throws Exception {
        Long productCategoryId=Long.valueOf(1);
        productCategory.setProductCategoryId(productCategoryId);
        assertEquals(productCategoryId,productCategory.getProductCategoryId());
    }

    @Test
    public void setProductCategoryId() throws Exception {

    }

    @Test
    public void getCategoryName() throws Exception {
        String categoryName="jackets";
        productCategory.setCategoryName("jackets");
        assertEquals(categoryName,productCategory.getCategoryName());
    }

    @Test
    public void setCategoryName() throws Exception {

    }

    @Test
    public void getProductList() throws Exception {

    }

    @Test
    public void setProductList() throws Exception {

    }

}