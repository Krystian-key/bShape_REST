package com.rest.bshape.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private Double weight;
    private Double gigajoule;
    private Double calories;
    private Double alcohol;
    private Double protein;
    private Double fat;
    private Double carbohydrates;

}
