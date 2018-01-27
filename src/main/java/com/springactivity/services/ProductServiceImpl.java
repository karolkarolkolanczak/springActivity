package com.springactivity.services;

import com.springactivity.model.Product;
import com.springactivity.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by a on 19/01/2018.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private List<Product> listOfAllProducts;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getListOfAllProducts() {
        Iterable<Product> iterator = productRepository.findAll();
        List<Product> listOfAllProducts = StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
        return listOfAllProducts;
    }

    @Override
    public Product getProductById(Long productId) {
        Product product=new Product();
        product=productRepository.findOne(productId);
        return product;
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        productRepository.save(product);
        return null;
    }

    @Override
    public Product editProduct(Product product) {
        return null;
    }

    @Override
    public Byte[] convertFromMultipartFileToByteFormatFile(MultipartFile file) {

        Byte[] byteObjects = new Byte[0];

        try {
             byteObjects = new Byte[file.getBytes().length];
            int i = 0;
            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }
        } catch (IOException e) {
            //todo handle better
            System.out.println("Exception From 'convertFromMultipartFileToByteFormatFile': "+e);
        }
        return byteObjects;
    }
}
