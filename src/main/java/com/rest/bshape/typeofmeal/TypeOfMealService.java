package com.rest.bshape.typeofmeal;

import com.rest.bshape.typeofmeal.domain.TypeOfMeal;
import com.rest.bshape.typeofmeal.domain.TypeOfMealID;

import java.util.List;

public interface TypeOfMealService {

    List<TypeOfMeal> findAll();

    TypeOfMeal findById(Long id);

    TypeOfMealID create(TypeOfMeal typeOfMeal);

    TypeOfMeal update(TypeOfMeal typeOfMeal, Long id);

    void delete(Long id);

}
