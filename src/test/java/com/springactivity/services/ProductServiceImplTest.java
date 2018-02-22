package com.springactivity.services;

import com.springactivity.model.Product;
import com.springactivity.repositories.PictureRepository;
import com.springactivity.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by a on 21/02/2018.
 */
public class ProductServiceImplTest {

    ProductServiceImpl productService;
    @Mock
    ProductRepository productRepository;
    @Mock
    PictureRepository pictureRepository;
    @Mock
    ProductCategoryService productCategoryService;


    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        productService=new ProductServiceImpl(productRepository,productCategoryService,pictureRepository);
    }

    @Test
    public void getListOfAllProducts() throws Exception {

        Product product=new Product();
        List<Product> list=new ArrayList<>();
        list.add(product);

        when(productRepository.findAll()).thenReturn(list);

        List<Product> listOfAllProducts = (List<Product>) productRepository.findAll();

        assertEquals(1,listOfAllProducts.size());

        verify(productRepository,times(1)).findAll();
    }

}