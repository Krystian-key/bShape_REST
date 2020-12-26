package com.rest.bshape.meal;

import com.rest.bshape.meal.domain.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface MealRepository extends JpaRepository<Meal, Long> {
}
