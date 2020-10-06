package com.rest.bshape.typeofmeal.impl;

import com.rest.bshape.typeofmeal.TypeOfMealRepository;
import com.rest.bshape.typeofmeal.TypeOfMealService;
import com.rest.bshape.typeofmeal.domain.TypeOfMeal;
import com.rest.bshape.typeofmeal.domain.TypeOfMealID;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TypeOfMealServiceImpl implements TypeOfMealService {

    private final TypeOfMealRepository typeOfMealRepository;

    public TypeOfMealServiceImpl(TypeOfMealRepository typeOfMealRepository) {
        this.typeOfMealRepository = typeOfMealRepository;
    }


    @Override
    public List<TypeOfMeal> findAll() {
        return this.typeOfMealRepository.findAll();

    }

    @Override
    public TypeOfMeal findById(Long id) {
        return typeOfMealRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BodyType not found with id :" + id));
    }

    @Override
    public TypeOfMealID create(TypeOfMeal typeOfMeal) {
        typeOfMeal = typeOfMealRepository.save(typeOfMeal);
        return new TypeOfMealID(typeOfMeal.getId());
    }


    @Override
    public TypeOfMeal update(TypeOfMeal typeOfMeal, Long id) {

        TypeOfMeal typeOfMealById = typeOfMealRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BodyType not found with id :" + id));

        typeOfMealById.setTypeMeals(typeOfMeal.getTypeMeals());
        return typeOfMealRepository.save(typeOfMealById);
    }


    @Override
    public void delete(Long id) {
        this.typeOfMealRepository.deleteById(id);
    }
}
