package com.springactivity.controllers;

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

    public IndexController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/")
    public String index(Model model){
        System.out.println("OKKKK");
        model.addAttribute("listOfAllproducts",productService.getListOfAllProducts());
        model.addAttribute("listOfAllProductCategories",productService.getInitialProductCategoryList());
        return "index";
    }
}