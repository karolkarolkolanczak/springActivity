package com.springactivity.services;

import com.springactivity.model.Gender;
import com.springactivity.model.Product;
import com.springactivity.model.ProductCategory;
import com.springactivity.model.ProductFeatures;
import com.springactivity.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
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
        insertData("Climate Jacket","Warm for winter days", BigDecimal.valueOf(179.99),createProductFeatures("black","75% cotton,25% polyester",Gender.MALE,900),createProductCategory("Jackets"),"static/images/burst.shopify.com/jacket1.jpg");
        insertData("Thermo T-shirt","Thermoactive t-shirt perfect for the gym", BigDecimal.valueOf(34.99),createProductFeatures("blue","100% cotton",Gender.MALE,80),createProductCategory("T-shirts"),"static/images/burst.shopify.com/tshirt1.jpg");
        insertData("Sky shoes","Blue navy sport shoes", BigDecimal.valueOf(79.99),createProductFeatures("blue","textile",Gender.MALE,550),createProductCategory("Shoes"),"static/images/burst.shopify.com/shoe1.jpg");
        insertData("Galaxy socks","Colourful design socks for creative person", BigDecimal.valueOf(9.99),createProductFeatures("colorful","80% cotton, 15% polyester, 5% spandex",Gender.UNISEX,60),createProductCategory("Socks"),"static/images/burst.shopify.com/sock1.jpg");
        insertData("Red purse","Modern city red purse for active woman", BigDecimal.valueOf(44.99),createProductFeatures("red","leather",Gender.FEMALE,630),createProductCategory("Purses"),"static/images/burst.shopify.com/purse1.jpg");
        insertData("Gold Tiny Necklace","Gold adjustable necklace", BigDecimal.valueOf(239.99),createProductFeatures("gold","gold",Gender.FEMALE,41),createProductCategory("Necklaces"),"static/images/burst.shopify.com/necklace1.jpg");
        insertData("Classic marble earrings","Marble earrings, handmade item, style: Boho", BigDecimal.valueOf(124.99),createProductFeatures("white","marble",Gender.FEMALE,18),createProductCategory("Earrings"),"static/images/burst.shopify.com/earrings1.jpg");
        insertData("Active watch","Black watch with quartz mechanism", BigDecimal.valueOf(49.99),createProductFeatures("black","leather",Gender.UNISEX,35),createProductCategory("Watches"),"static/images/burst.shopify.com/watch1.jpg");
    }

    ProductFeatures createProductFeatures(String color, String material, Gender gender,int weight){
        ProductFeatures productFeatures=new ProductFeatures();
        productFeatures.setColor(color);
        productFeatures.setMaterial(material);
        productFeatures.setGender(gender);
        productFeatures.setWeight(weight);
        return productFeatures;
    }

    ProductCategory createProductCategory(String categoryName){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName(categoryName);
        return productCategory;
    }

    public void insertData(String productName, String productDescription,BigDecimal price,ProductFeatures productFeatures, ProductCategory productCategory,String pictureSource){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(pictureSource).getFile());
        Product product=new Product(productName,productDescription,price, productFeatures, productCategory,imageReader(file));
        saveOrUpdateProduct(product);
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
