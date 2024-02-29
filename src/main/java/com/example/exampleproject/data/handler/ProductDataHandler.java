package com.example.exampleproject.data.handler;

import com.example.exampleproject.data.entity.ProductEntity;

public interface ProductDataHandler {
    ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);
    ProductEntity getProductEntity(String productId);
}
