package com.springactivity.repositories;

import com.springactivity.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by a on 25/01/2018.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.productCategory.productCategoryId=:productCategoryId")
    List<Product> productListByCategoryId(@Param("productCategoryId") Long productCategoryId);

}
