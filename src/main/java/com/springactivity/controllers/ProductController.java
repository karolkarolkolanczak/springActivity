package com.springactivity.controllers;

import com.springactivity.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "products";
    }

}
