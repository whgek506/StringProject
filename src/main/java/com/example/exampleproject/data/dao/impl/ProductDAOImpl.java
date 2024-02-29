package com.example.exampleproject.data.dao.impl;

import com.example.exampleproject.data.dao.ProductDAO;
import com.example.exampleproject.data.entity.ProductEntity;
import com.example.exampleproject.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO { //실제화

    ProductRepository productRepository;

    @Autowired //@Autowired : 위에 정의 한 객체를 new 할 필요없이 끌어와서 사용 가능
    public ProductDAOImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }
    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId) {
        ProductEntity productEntity = productRepository.getById(productId);
        return productEntity;
    }
}
