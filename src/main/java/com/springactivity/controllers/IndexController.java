package com.springactivity.controllers;

import com.springactivity.services.ProductCategoryService;
import com.springactivity.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by a on 18/01/2018.
 */
@Controller
public class IndexController {

    private ProductService productService;
    private ProductCategoryService productCategoryService;

    public IndexController(ProductService productService,ProductCategoryService productCategoryService) {
        this.productService = productService;
        this.productCategoryService=productCategoryService;
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("listOfAllproducts",productService.getListOfAllProducts());
        model.addAttribute("listOfAllProductCategories",productCategoryService.getListOfAllProductCategories());
        return "index";
    }
}