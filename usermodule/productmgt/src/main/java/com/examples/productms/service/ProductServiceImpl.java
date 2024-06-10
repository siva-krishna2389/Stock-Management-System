package com.examples.productms.service;

import com.examples.productms.dto.CreateProductRequest;
import com.examples.productms.dto.ProductDetails;
import com.examples.productms.entities.Product;
import com.examples.productms.exceptions.ProductNotFoundException;
import com.examples.productms.repository.IProductRepository;
import com.examples.productms.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ProductUtil productUtil;

    @Override
    public ProductDetails add(CreateProductRequest request) {
        Product product=new Product();
        product.setName(request.getName());
        product=productRepository.save(product);
        ProductDetails desired=productUtil.toDetails(product);
        return desired;
    }

    @Override
    public ProductDetails findById(long productId) {
       Optional<Product> optional=  productRepository.findById(productId);
        if(!optional.isPresent()){
            throw new ProductNotFoundException("product is not found");
        }
        Product product= optional.get();
        ProductDetails desired=productUtil.toDetails(product);
        return desired ;
    }
}
