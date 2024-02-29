package com.example.exampleproject.data.dto;

import com.example.exampleproject.data.entity.ProductEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {
    //@NonNull : validation의 어노테이션 중 Null 값이 있으면 안되게 설정
    @NonNull
    @Size(min = 8, max = 8)
    private String productId;

    @NonNull
    private String productName;

    @NonNull
    @Min(value = 500) //Min() : 최소 가격 지정
    @Max(value = 3000000) //Max() : 최대 가격 지정
    private int productPrice; //상품 가격

    @NonNull
    @Min(value = 0) //Min() : 최소 수량 지정
    @Max(value = 9999) //Max() : 최대 수량 지정
    private int productStock; //상품 수량

    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }

}
