package com.rest.bshape.meal.impl;

import com.rest.bshape.meal.MealRepository;
import com.rest.bshape.meal.MealService;
import com.rest.bshape.meal.domain.Meal;
import com.rest.bshape.meal.domain.MealID;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public List<Meal> findAll() {
        return this.mealRepository.findAll();
    }

    @Override
    public Meal findById(Long id) {
        return mealRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BodyType not found with id :" + id));
    }

    @Override
    public MealID create(Meal meal) {
        meal = mealRepository.save(meal);
        return new MealID(meal.getId());
    }

    @Override
    public Meal update(Meal meal, Long id) {

        return mealRepository.save(findById(id)
                .toBuilder()
                .mealName(meal.getMealName())
                .build());
    }

    @Override
    public void delete(Long id) {
        this.mealRepository.deleteById(id);
    }
}
