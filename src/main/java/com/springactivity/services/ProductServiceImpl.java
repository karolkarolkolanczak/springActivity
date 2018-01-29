package com.springactivity.services;

import com.springactivity.model.Product;
import com.springactivity.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.ArrayUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Files;
import java.util.Arrays;
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
    public void saveOrUpdateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product editProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.delete(getProductById(productId));
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
            System.out.println("Exception From 'convertFromMultipartFileToByteFormatFile': "+e);
        }
        return byteObjects;
    }

    @Override
    public void dataBaseProductInitialList() {
        ClassLoader classLoader = getClass().getClassLoader();

        File shoe1 = new File(classLoader.getResource("static/images/burst.shopify.com/shoe1.jpg").getFile());
        File purse1 = new File(classLoader.getResource("static/images/burst.shopify.com/purse1.jpg").getFile());
        File tshirt1 = new File(classLoader.getResource("static/images/burst.shopify.com/tshirt1.jpg").getFile());
        File earrings1 = new File(classLoader.getResource("static/images/burst.shopify.com/earrings1.jpg").getFile());
        File sock1 = new File(classLoader.getResource("static/images/burst.shopify.com/sock1.jpg").getFile());

        Product product1=new Product(Long.valueOf(1),"Blue shoes","Blue navy sport shoes",BigDecimal.valueOf(99.99),imageReader(shoe1));
        Product product2=new Product(Long.valueOf(2),"Red purse","Modern city red purse for active woman",BigDecimal.valueOf(44.99),imageReader(purse1));
        Product product3=new Product(Long.valueOf(3),"Thermo T-shirt","Thermoactive t-shirt perfect for the gym",BigDecimal.valueOf(34.99),imageReader(tshirt1));
        Product product4=new Product(Long.valueOf(4),"White marble earrings","Marble earringngs, handmade item, style: Boho ",BigDecimal.valueOf(124.99),imageReader(earrings1));
        Product product5=new Product(Long.valueOf(5),"Galaxy socks","Colourful design socks for woman",BigDecimal.valueOf(9.99),imageReader(sock1));

        saveOrUpdateProduct(product1);
        saveOrUpdateProduct(product2);
        saveOrUpdateProduct(product3);
        saveOrUpdateProduct(product4);
        saveOrUpdateProduct(product5);
    }

    Byte[] imageReader(File file){
        byte[] fileContent = new byte[0];
        Byte[] byteObjects=new Byte[0];
        try {
            fileContent = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        byteObjects=primitiveBytesArrayToObjectBytesArrayConverter(fileContent);
        return byteObjects;
    }

    Byte[] primitiveBytesArrayToObjectBytesArrayConverter(byte[] primitiveBytes){
        Byte[] byteObjects = new Byte[primitiveBytes.length];
        Arrays.setAll(byteObjects, n -> primitiveBytes[n]);
        return byteObjects;
    }
}
