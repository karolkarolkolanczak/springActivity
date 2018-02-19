package com.springactivity.controllers;

import com.springactivity.model.*;
import com.springactivity.services.GenderService;
import com.springactivity.services.ProductCategoryService;
import com.springactivity.services.ProductService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
    private ProductCategoryService productCategoryService;
    private GenderService genderService;
    private List<ProductCategory> productCategoryList;

    @Autowired
    public ProductController(ProductService productService,ProductCategoryService productCategoryService,GenderService genderService) {
        this.productService = productService;
        this.productCategoryService=productCategoryService;
        this.genderService=genderService;
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
        productForm.setProductCategoryList(productCategoryService.getListOfAllProductCategories());
        productForm.setListOfGenders(genderService.getListOfGenders());
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
        productForm.setColor(product.getProductFeatures().getColor());
        productForm.setMaterial(product.getProductFeatures().getMaterial());
        productForm.setWeight(product.getProductFeatures().getWeight());
        productForm.setGender(product.getProductFeatures().getGender());
        productForm.setProductCategory(product.getProductCategory());
        productForm.setProductCategoryList(productCategoryService.getListOfAllProductCategories());
        productForm.setListOfGenders(genderService.getListOfGenders());
        productForm.setDataProductFromDatabase(true);
        model.addAttribute("productById", productService.getProductById(id));
        model.addAttribute("productForm", productForm);
        return "productEdit";
    }

    @RequestMapping(value = "/productFormSubmit", method = RequestMethod.POST)
    String addOrUpdateProduct(@Valid @ModelAttribute("productForm") ProductForm productForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            productForm.setProductCategoryList(productCategoryService.getListOfAllProductCategories());
            productForm.setListOfGenders(genderService.getListOfGenders());
            if(productForm.isDataProductFromDatabase()){
                return "productEdit";
            }
            else{
                return "productForm";
            }
        }

        Product product=new Product();
        if(productForm.getProductId()!=null){
            product.setProductId(productForm.getProductId());
        }
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        product.setPrice(productForm.getPrice());

        ProductFeatures productFeatures=new ProductFeatures();
        productFeatures.setColor(productForm.getColor());
        productFeatures.setMaterial(productForm.getMaterial());
        productFeatures.setWeight(productForm.getWeight());
        productFeatures.setGender(productForm.getGender());
        product.setProductFeatures(productFeatures);

        ProductCategory productCategory=new ProductCategory();
        productCategory=productCategoryService.getProductCategoryById(productForm.getProductCategory().getProductCategoryId());

        product.setProductCategory(productCategory);

        if(productForm.getFile()!=null && productForm.getImage() != null){
            // converting data type 'MultipartFile' from Product Form to readable by database data type 'Byte[]'
            Byte[] image=productService.convertFromMultipartFileToByteFormatFile(productForm.getFile());
            product.setImage(image);
        }
        if( productForm.getFile().getSize()==0 && productForm.getImage() != null){
            product.setImage(productForm.getImage());
        }
        if(productForm.getFile()!=null && productForm.getImage() == null){
            Byte[] image=productService.convertFromMultipartFileToByteFormatFile(productForm.getFile());
            product.setImage(image);
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
