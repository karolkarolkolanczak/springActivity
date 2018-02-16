package com.springactivity.services;

import com.springactivity.model.ProductCategory;
import com.springactivity.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by a on 12/02/2018.
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

   private ProductCategoryRepository productCategoryRepository;
   private List<ProductCategory>listOfAllProductCategory;

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

    @Override
    public List<ProductCategory> getListOfAllProductCategories() {
        Iterable<ProductCategory> iterator = productCategoryRepository.findAll();
        List<ProductCategory> listOfAllProductCategory = StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
        return listOfAllProductCategory;
    }
}
