package com.springactivity.controllers;

import com.springactivity.model.Product;
import com.springactivity.model.ProductForm;
import com.springactivity.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;

/**
 * Created by a on 18/01/2018.
 */
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    String showListOfAllProducts(Model model){
        model.addAttribute("listOfAllproducts",productService.getListOfAllProducts());
        System.out.println("----DONE---");
        return "products";
    }

    @RequestMapping("/product/{id}")
    String getProductById(@PathVariable Long id, Model model){
        model.addAttribute("productById", productService.getProductById(id));
        return "product";
    }

    @RequestMapping("/productForm")
    String addNewProduct(Model model){
        ProductForm productForm =new ProductForm();
        model.addAttribute("productForm",productForm );
        return "productForm";
    }

    @RequestMapping("/productFormSubmit")
    String addNewProduct(ProductForm productForm ){
        Product product=new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        product.setPrice(productForm.getPrice());
        // converting data type 'MultipartFile' from Product Form to readable by database data type 'Byte[]'
        Byte[] image=productService.convertFromMultipartFileToByteFormatFile(productForm.getFile());;
        product.setImage(image);
        productService.saveOrUpdateProduct(product);
        return "index";
    }



}
