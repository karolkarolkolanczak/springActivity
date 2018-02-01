package com.springactivity.controllers;

import com.springactivity.model.Product;
import com.springactivity.model.ProductForm;
import com.springactivity.services.ProductService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by a on 18/01/2018.
 */
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
        productService.dataBaseProductInitialList();
    }

    @RequestMapping("/products")
    String showListOfAllProducts(Model model){
        model.addAttribute("listOfAllproducts",productService.getListOfAllProducts());
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

    @RequestMapping("/editProduct/{id}")
    String editProduct(@PathVariable Long id, Model model){
        Product product=new Product();
        product=productService.getProductById(id);
        ProductForm productForm=new ProductForm();
        productForm.setProductId(product.getProductId());
        productForm.setName(product.getName());
        productForm.setDescription(product.getDescription());
        productForm.setPrice(product.getPrice());
        productForm.setImage(product.getImage());
        productForm.setDataProductFromDatabase(true);
        model.addAttribute("productForm", productForm);
        return "productEdit";
    }

    @RequestMapping(value = "/productFormSubmit", method = RequestMethod.POST)
    String addNewProduct(@Valid @ModelAttribute ProductForm productForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            if(productForm.isDataProductFromDatabase()){
                return "productEdit";
            }
            else return "productForm";
        }
        Product product=new Product();
        if(productForm.getProductId()!=null){
            product.setProductId(productForm.getProductId());
        }
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        product.setPrice(productForm.getPrice());

        if(productForm.getFile()!=null && productForm.getImage() != null){
            // converting data type 'MultipartFile' from Product Form to readable by database data type 'Byte[]'
            Byte[] image=productService.convertFromMultipartFileToByteFormatFile(productForm.getFile());
            product.setImage(image);
        }
        if(productForm.getImage() != null && productForm.getFile().getSize()==0){
            product.setImage(productForm.getImage());
        }
            productService.saveOrUpdateProduct(product);
        return "redirect:/products";
    }

    @GetMapping("product/{id}/image")
    public void getImageFromDataBase(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Product product=new Product();
        product=productService.getProductById(id);

        if (product.getImage() != null) {
            byte[] byteArray = new byte[product.getImage().length];
            int i = 0;

            for (Byte wrappedByte : product.getImage()) {
                byteArray[i++] = wrappedByte; //auto unboxing
            }
            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }

    @RequestMapping("/productDelete/{id}")
    String deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return "redirect:/products";
    }
}
