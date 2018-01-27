package com.springactivity.services;

import com.springactivity.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by a on 19/01/2018.
 */
public interface ProductService {
    List<Product> getListOfAllProducts();

    Product getProductById(Long productId);

    Product saveOrUpdateProduct(Product product);

    Product editProduct(Product product);

    Byte[] convertFromMultipartFileToByteFormatFile(MultipartFile file);
}
