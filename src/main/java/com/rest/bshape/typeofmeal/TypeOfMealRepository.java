package com.rest.bshape.typeofmeal;


import com.rest.bshape.typeofmeal.domain.TypeOfMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface TypeOfMealRepository extends JpaRepository<TypeOfMeal, Long> {
}
