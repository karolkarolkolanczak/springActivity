package com.springactivity.controllers;

import com.springactivity.services.ProductCategoryService;
import com.springactivity.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

/**
 * Created by a on 13/02/2018.
 */
@Controller
public class ProductCategoryController {
    private ProductCategoryService productCategoryService;
    private ProductService productService;

    @Autowired
    public ProductCategoryController(ProductService productService,ProductCategoryService productCategoryService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
    }

    @RequestMapping("/productCategory/{id}")
    @Transactional
    String showSelectedCategry(@PathVariable Long id, Model model){
        model.addAttribute("productCategory",productCategoryService.getProductCategoryById(id));
        model.addAttribute("ProductListByCategoryId",productService.getProductListByCategoryId(id));
        return "productCategory";
    }

    @RequestMapping("/productCategories")
    @Transactional
    public String productCategories(Model model){
        model.addAttribute("listOfAllproducts",productService.getListOfAllProducts());
        model.addAttribute("listOfAllProductCategories",productCategoryService.getListOfAllProductCategories());
        return "productCategories";
    }
}
