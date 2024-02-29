package com.example.exampleproject.data.dao;

import com.example.exampleproject.data.entity.ProductEntity;

public interface ProductDAO { //메소드 선언
    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);
}
