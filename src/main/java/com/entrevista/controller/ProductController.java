package com.entrevista.controller;

import com.entrevista.model.Client;
import com.entrevista.model.Product;
import com.entrevista.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Product> getClientList() {
        List<Product> productList = new ArrayList<>();
        productList.addAll(productService.getAllProducts());
        return productList;
    }
}
