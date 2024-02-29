package com.example.exampleproject.data.handler.impl;

import com.example.exampleproject.data.dao.ProductDAO;
import com.example.exampleproject.data.entity.ProductEntity;
import com.example.exampleproject.data.handler.ProductDataHandler;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {
    ProductDAO productDAO;

    @Autowired
    public ProductDataHandlerImpl(ProductDAO productDAO) {

        this.productDAO = productDAO;
    }
    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice, productStock);

        return productDAO.saveProduct(productEntity);
    }

    @Override
    public ProductEntity getProductEntity(String productId) {

        return productDAO.getProduct(productId); //아이디럴 넘겨줌으로 DB에ㅓ DATO가 엔티티를 호출
    }
}
