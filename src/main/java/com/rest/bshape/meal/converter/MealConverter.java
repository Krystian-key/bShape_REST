package com.rest.bshape.meal.converter;

import com.rest.bshape.meal.domain.Meal;
import com.rest.bshape.meal.domain.MealDTO;

import java.util.List;
import java.util.stream.Collectors;


public class MealConverter {

    public static MealDTO convertToDTO(Meal meal) {
        return MealDTO.builder()
                .id(meal.getId())
                .mealName(meal.getMealName())
                .build();
    }

    public static Meal convertFromDTO(MealDTO mealDTO) {
        return Meal.builder()
                .id(mealDTO.getId())
                .mealName(mealDTO.getMealName())
                .build();
    }

    public static List<MealDTO> mapToListDto(List<Meal> mealList) {
        return mealList.stream()
                .map(MealConverter::convertToDTO)
                .collect(Collectors.toList());
    }
}
