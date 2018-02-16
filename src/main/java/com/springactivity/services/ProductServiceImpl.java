package com.springactivity.services;

import com.springactivity.model.Gender;
import com.springactivity.model.Product;
import com.springactivity.model.ProductCategory;
import com.springactivity.model.ProductFeatures;
import com.springactivity.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
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
    private ProductRepository productRepository;
    private ProductCategoryService productCategoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,ProductCategoryService productCategoryService) {
        this.productRepository = productRepository;
        this.productCategoryService=productCategoryService;
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

    @Transactional
    @Override
        public void databaseInitialLoad() {
        insertData("Climate Jacket","Warm for winter days", BigDecimal.valueOf(179.99),createProductFeatures("black","75% cotton, 25% polyester",Gender.MALE,BigDecimal.valueOf(900)),createProductCategory("Jackets"),"static/images/burst.shopify.com/jacket1.jpg");
        insertData("Funky Jacket","Funny jacket for full of joy", BigDecimal.valueOf(129.99),createProductFeatures("blue","50% cotton, 50% polyester",Gender.MALE,BigDecimal.valueOf(750)),createProductCategory("Jackets"),"static/images/burst.shopify.com/jacket2.jpg");
        insertData("Thermo blue T-shirt","Thermoactive blue t-shirt perfect for the gym", BigDecimal.valueOf(34.99),createProductFeatures("blue","100% cotton",Gender.MALE,BigDecimal.valueOf(80)),createProductCategory("T-shirts"),"static/images/burst.shopify.com/tshirt1.jpg");
        insertData("Thermo purple T-shirt","Thermoactive purple t-shirt perfect for the gym", BigDecimal.valueOf(34.99),createProductFeatures("purple","100% cotton",Gender.MALE,BigDecimal.valueOf(80)),createProductCategory("T-shirts"),"static/images/burst.shopify.com/tshirt2.jpg");
        insertData("Sky shoes","Blue navy sport shoes", BigDecimal.valueOf(79.99),createProductFeatures("blue","textile",Gender.MALE,BigDecimal.valueOf(550)),createProductCategory("Shoes"),"static/images/burst.shopify.com/shoe1.jpg");
        insertData("Space shoes","Happy dance shoes", BigDecimal.valueOf(89.99),createProductFeatures("red","textile",Gender.UNISEX,BigDecimal.valueOf(600)),createProductCategory("Shoes"),"static/images/burst.shopify.com/shoe2.jpg");
        insertData("Galaxy socks","Colourful design socks for creative person", BigDecimal.valueOf(9.99),createProductFeatures("colorful","80% cotton, 15% polyester, 5% spandex",Gender.UNISEX,BigDecimal.valueOf(60)),createProductCategory("Socks"),"static/images/burst.shopify.com/sock1.jpg");
        insertData("Happy socks","Orange socks for happy person", BigDecimal.valueOf(9.99),createProductFeatures("orange","80% cotton, 15% polyester, 5% spandex",Gender.UNISEX,BigDecimal.valueOf(60)),createProductCategory("Socks"),"static/images/burst.shopify.com/sock2.jpg");
        insertData("Red purse","Modern city red purse for active woman", BigDecimal.valueOf(44.99),createProductFeatures("red","leather",Gender.FEMALE,BigDecimal.valueOf(630)),createProductCategory("Purses"),"static/images/burst.shopify.com/purse1.jpg");
        insertData("Brown purse","Purse for businesswoman", BigDecimal.valueOf(79.99),createProductFeatures("brown","leather",Gender.FEMALE,BigDecimal.valueOf(700)),createProductCategory("Purses"),"static/images/burst.shopify.com/purse2.jpg");
        insertData("Gold tiny necklace","Gold adjustable necklace", BigDecimal.valueOf(239.99),createProductFeatures("gold","gold",Gender.FEMALE,BigDecimal.valueOf(41)),createProductCategory("Necklaces"),"static/images/burst.shopify.com/necklace1.jpg");
        insertData("Pigeon necklace","Gold necklace with pigeon", BigDecimal.valueOf(199.99),createProductFeatures("gold","gold",Gender.FEMALE,BigDecimal.valueOf(38)),createProductCategory("Necklaces"),"static/images/burst.shopify.com/necklace2.jpg");
        insertData("Classic marble earrings","Marble earrings, handmade item, style: Boho", BigDecimal.valueOf(124.99),createProductFeatures("white","marble",Gender.FEMALE,BigDecimal.valueOf(18)),createProductCategory("Earrings"),"static/images/burst.shopify.com/earrings1.jpg");
        insertData("Butterfly earrings","Butterfly earrings, handmade item", BigDecimal.valueOf(139.99),createProductFeatures("gold","gold",Gender.FEMALE,BigDecimal.valueOf(22)),createProductCategory("Earrings"),"static/images/burst.shopify.com/earrings2.jpg");
        insertData("Active watch","Black watch with quartz mechanism", BigDecimal.valueOf(49.99),createProductFeatures("black","leather",Gender.UNISEX,BigDecimal.valueOf(35)),createProductCategory("Watches"),"static/images/burst.shopify.com/watch1.jpg");
        insertData("Abstract watch","Blue watch with quartz mechanism", BigDecimal.valueOf(49.99),createProductFeatures("blue","leather",Gender.UNISEX,BigDecimal.valueOf(35)),createProductCategory("Watches"),"static/images/burst.shopify.com/watch2.jpg");
    }

    ProductFeatures createProductFeatures(String color, String material, Gender gender,BigDecimal weight){
        ProductFeatures productFeatures=new ProductFeatures();
        productFeatures.setColor(color);
        productFeatures.setMaterial(material);
        productFeatures.setGender(gender);
        productFeatures.setWeight(weight);
        return productFeatures;
    }

    ProductCategory createProductCategory(String categoryName) {
        ProductCategory productCategory = new ProductCategory();

        if (productCategoryService.getListOfAllProductCategories().size() == 0) {
            productCategory.setCategoryName(categoryName);
        }
        if (productCategoryService.getListOfAllProductCategories().size() > 0) {
            for (ProductCategory value : productCategoryService.getListOfAllProductCategories()) {
                if ( value.getCategoryName().equals(categoryName)) {
                    productCategory=productCategoryService.getProductCategoryById(value.getProductCategoryId());
                }
                if (!value.getCategoryName().equals(categoryName)) {
                    productCategory.setCategoryName(categoryName);
                }
            }
        }
        return productCategory;
    }

    public void insertData(String productName, String productDescription,BigDecimal price,ProductFeatures productFeatures, ProductCategory productCategory,String pictureSource){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(pictureSource).getFile());
        Product product=new Product(productName,productDescription,price, productFeatures, productCategory,imageReader(file));
        saveOrUpdateProduct(product);
    }

    public Byte[] imageReader(File file){
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

    public Byte[] primitiveBytesArrayToObjectBytesArrayConverter(byte[] primitiveBytes){
        Byte[] byteObjects = new Byte[primitiveBytes.length];
        Arrays.setAll(byteObjects, n -> primitiveBytes[n]);
        return byteObjects;
    }

    @Override
    public List<Product> getProductListByCategoryId(Long productCategoryId) {
        List<Product> productListByCategoryId=new ArrayList<>();
        productListByCategoryId=productRepository.productListByCategoryId(productCategoryId);
        return productListByCategoryId;
    }

}
