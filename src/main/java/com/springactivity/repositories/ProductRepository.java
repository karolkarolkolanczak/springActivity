package com.springactivity.repositories;

import com.springactivity.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by a on 25/01/2018.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
