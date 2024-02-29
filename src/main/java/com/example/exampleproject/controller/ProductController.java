package com.example.exampleproject.controller;

import com.example.exampleproject.data.dto.ProductDto;
import com.example.exampleproject.data.entity.ProductEntity;
import com.example.exampleproject.data.service.ProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    //client에서 controlloer로 요청값이 들어오면 어떤 요청 값이 각각 맞게 매핑 되어있는 메소드들 찾아감
    // -> 비즈니스 로직인 해당 서비스의 메소드로 값을 전달
    private ProductService productService;
    Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired //@Autowired : new를 사용해서 객체를 생성 할 필요 없이 앞에서 선언한 객체를 끌어다 쓸 수 있게 해줌
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    //http://localhost:8080/api/v1/product-api/product/%7BproductId%7D
    @GetMapping(value = "/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId) {

        return productService.getProduct(productId);
    }

    //http://localhost:8080/api/v1/product-api/product/
    @PostMapping(value = "/product")
    //@Valid : productDto에서 설정한 유효성 검사(Validation)를 실행
    public ResponseEntity<ProductDto> creteProduct(@Valid @RequestBody ProductDto productDto) { //Dto가 DB에 저장이 완료 되었으면 Dto 값을 그대로 리턴

        //Validation Code Example
        //1. 값이 없거나 비어있는지 체크
        //2. 맞다면 LOGGER를 조회했을 때 설정한 에러 메세지를 출력함
        //3. HttpStatus에 BAD_REQUEST 코드를 넣어주고 productDto를 리턴
        if(productDto.getProductId().equals("") || productDto.getProductId().isEmpty()) { //값이 없거나 비어져 있을 때 설정한 LOGGER 에러 메세지를 출력하고 productDto를 리턴
            LOGGER.error("[createProduct] failed Response :: productId is Empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productDto);
        }

        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        ProductDto response = productService.saveProduct(productId, productName, productPrice, productStock);

        //로그 설정
        LOGGER.info(
                "[createProduct] Response >> prodictId : {}, productName : {}, productPrice : {}, productStock : {}",
                response.getProductId(), response.getProductName(), response.getProductPrice(), response.getProductStock()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    //http://localhost:8080/api/v1/product-api/product/%7BproductId%7D
    @DeleteMapping(value = "/product/{productId}")
    public  ProductDto deleteProduct(@PathVariable String productId) {
        return null;
    }
}
