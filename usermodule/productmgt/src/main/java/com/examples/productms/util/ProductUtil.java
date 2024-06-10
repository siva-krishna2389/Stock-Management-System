package com.examples.productms.util;


import com.examples.productms.dto.ProductDetails;
import com.examples.productms.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductUtil {

    public ProductDetails toDetails(Product product){
        ProductDetails desired=new ProductDetails();
        desired.setProductId(product.getProductId());
        desired.setName(product.getName());
        return desired;
    }

}
