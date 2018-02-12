package com.springactivity.repositories;

import com.springactivity.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by a on 12/02/2018.
 */
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
}
