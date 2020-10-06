package com.rest.bshape.typeofmeal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TypeOfMealDTO {

    private Long id;

    private String typeMeals;

}
