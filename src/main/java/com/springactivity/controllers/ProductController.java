package com.springactivity.controllers;

import com.springactivity.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
