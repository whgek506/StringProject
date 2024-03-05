package com.example.exampleproject.data.entity;

import com.example.exampleproject.data.dto.ProductDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product") //@Table : 엔티티를 기반으로 DB에 테이블을 자동으로 생성 (name = "생성 할 테이블명")
//Entity : DB 테이블과 1:1로 밀접한 관계 (DTO와 유사)
public class ProductEntity {

   @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //PK
    String productId;
    String productName;
    Integer productPrice;
    Integer productStock;

    public ProductDto toDto(){
        return ProductDto.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }
}
