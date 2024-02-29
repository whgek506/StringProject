package com.example.exampleproject.data.repository;

import com.example.exampleproject.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//JpaRepository<엔티티, PK의 데이터 타입(productId)> => @Repository를 대신 사용
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}