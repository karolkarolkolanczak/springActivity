package com.springactivity.services;

import com.springactivity.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 19/01/2018.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private List<Product> listOfAllProducts;

    public ProductServiceImpl() {
        getListOfAllProducts();
    }

    @Override
    public List<Product> getListOfAllProducts() {
        listOfAllProducts=new ArrayList<>();

        Product product1=new Product();
        product1.setProductId(1);
        product1.setDescription("t-sirt");
        product1.setPrice(10);
        product1.setFotoImageUrl("https://www.militaria.pl/upload/wysiwyg/gfx/produkty/HELIKON/T-shirt/Koszulka-Helikon-3-Color-Desert-ts-tsh-co-05.jpg");
        listOfAllProducts.add(product1);

        Product product2=new Product();
        product2.setProductId(2);
        product2.setDescription("shoe");
        product2.setPrice(29.99);
        product2.setFotoImageUrl("https://www.militaria.pl/upload/wysiwyg/gfx/produkty/Zephyr/Buty_Zephyr_Grom_Z007/Buty_Zephyr_Grom_BLK_Z007.jpg");
        listOfAllProducts.add(product2);

        Product product3=new Product();
        product3.setProductId(3);
        product3.setDescription("multitool");
        product3.setPrice(15.33);
        product3.setFotoImageUrl("https://www.militaria.pl/upload/wysiwyg/gfx/produkty/noze/Victorinox/3_0227_L/multitool-victorinox-swisstool-spirit-3-0227-L.jpg");
        listOfAllProducts.add(product3);

        Product product4=new Product();
        product4.setProductId(4);
        product4.setDescription("jacket");
        product4.setPrice(122.25);
        product4.setFotoImageUrl("https://www.militaria.pl/upload/wysiwyg/gfx/produkty/Brandit/kurtka_brandit_m65_olive.jpg");
        listOfAllProducts.add(product4);

        return listOfAllProducts;
    }

    @Override
    public Product getProductById(Integer productId) {
        Product product=new Product();

        for(Product value:listOfAllProducts){
            if(value.getProductId()==productId){
                product=value;
            }
        }
        return product;
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        return null;
    }

    @Override
    public Product editProduct(Product product) {
        return null;
    }
}
