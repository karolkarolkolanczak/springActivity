package com.springactivity.services;

import com.springactivity.model.Product;
import com.springactivity.model.ProductCategory;
import com.springactivity.model.ProductFeatures;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by a on 19/01/2018.
 */
public interface ProductService {

    List<Product> getListOfAllProducts();

    Product getProductById(Long productId);

    void saveOrUpdateProduct(Product product);

    Product editProduct(Product product);

    void deleteProductById(Long productId);

    Byte[] convertFromMultipartFileToByteFormatFile(MultipartFile file);

    void databaseInitialLoad();

    List<Product> getProductListByCategoryId(Long productCategoryId);
}
