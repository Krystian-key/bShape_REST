package com.rest.bshape.meal;

import com.rest.bshape.meal.domain.Meal;
import com.rest.bshape.meal.domain.MealID;

import java.util.List;

public interface MealService {

    List<Meal> findAll();

    Meal findById(Long id);

    MealID create(Meal meal);

    Meal update(Meal meal, Long id);

    void delete(Long id);
}
