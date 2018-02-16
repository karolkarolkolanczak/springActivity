package com.springactivity.services;

import com.springactivity.model.ProductCategory;

import java.util.List;

/**
 * Created by a on 12/02/2018.
 */
public interface ProductCategoryService {

    ProductCategory getProductCategoryById(Long productCategoryId);

    List<ProductCategory> getListOfAllProductCategories();
}
