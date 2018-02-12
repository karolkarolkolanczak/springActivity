package com.springactivity.services;

import com.springactivity.model.ProductCategory;
import com.springactivity.repositories.ProductCategoryRepository;
import com.springactivity.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by a on 12/02/2018.
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

   private ProductCategoryRepository productCategoryRepository;

   @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public ProductCategory getProductCategoryById(Long productCategoryId) {
        ProductCategory productCategory=new ProductCategory();
        productCategory=productCategoryRepository.findOne(productCategoryId);
        return productCategory;
    }
}
