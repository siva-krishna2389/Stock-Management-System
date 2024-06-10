package com.examples.productms.controller;

import com.examples.productms.dto.CreateProductRequest;
import com.examples.productms.dto.ProductDetails;
import com.examples.productms.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     *  only admin can accesss it as url starting from /a
     */
    @PostMapping("/a/products/add")
    public ProductDetails add(@RequestBody CreateProductRequest request) {
        ProductDetails response = productService.add(request);
        return response;
    }

    /**
     *
     * both customers and admins can access as url starting from /c
     */
    @GetMapping("/c/products/byid/{id}")
    public ProductDetails getProduct(@PathVariable("id") Long id) {
        ProductDetails response = productService.findById(id);
        return response;
    }


}
