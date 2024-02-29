package com.example.exampleproject.data.service;

import com.example.exampleproject.data.dto.ProductDto;

public interface ProductService {
    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock); //ProductDto로 저장
    ProductDto getProduct(String productId); //productId로 조회
}

/*
<인터페이스 / impl로 따로 분리하는 이유>
-호출하는 객체 자체는 인터페이스로 설정
-실제는 impl에서 실행
=> 메소드 별로 각각 어울리는 프로퍼티 값을 설정하고, 변동 할 수 있게해야 상황에 맞는 객체 불러올 수 있기 때문
 */