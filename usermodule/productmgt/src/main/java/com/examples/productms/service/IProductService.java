package com.examples.productms.service;

import com.examples.productms.dto.CreateProductRequest;
import com.examples.productms.dto.ProductDetails;

public interface IProductService {

   ProductDetails add(CreateProductRequest request);

   ProductDetails findById(long productId);


}
