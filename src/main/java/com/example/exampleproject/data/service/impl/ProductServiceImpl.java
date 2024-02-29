package com.example.exampleproject.data.service.impl;

import com.example.exampleproject.data.dto.ProductDto;
import com.example.exampleproject.data.entity.ProductEntity;
import com.example.exampleproject.data.handler.ProductDataHandler;
import com.example.exampleproject.data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//impl : 실제 실행
public class ProductServiceImpl implements ProductService {

    ProductDataHandler productDataHandler; //handeler : 핸들링 작업이 필요할 때 사용(옵션사항)

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler) {
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);

        ProductDto productDto = new ProductDto(productEntity.getProductId(),
                                                productEntity.getProductName(),
                                                productEntity.getProductPrice(),
                                                productEntity.getProductStock());

        return productDto;
    }

    @Override
    public ProductDto getProduct(String productId) {
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);

        //productEntity에서 값을 받아서 productDto로 변환
        ProductDto productDto = new ProductDto(productEntity.getProductId(),
                                                productEntity.getProductName(),
                                                productEntity.getProductPrice(),
                                                productEntity.getProductStock());

        return productDto; //Controller에서 productDto를 리턴 받길 원하기 때문
    }
}
