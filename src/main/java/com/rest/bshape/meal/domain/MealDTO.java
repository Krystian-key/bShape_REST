package com.rest.bshape.meal.domain;

import com.rest.bshape.product.ProductDTO;
import lombok.*;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MealDTO {

    private Long id;

    private String mealName;

    private List<ProductDTO> productDTO;
}
