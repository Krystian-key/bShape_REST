package com.rest.bshape.typeofmeal.converter;


import com.rest.bshape.typeofmeal.domain.TypeOfMeal;
import com.rest.bshape.typeofmeal.domain.TypeOfMealDTO;

import java.util.List;
import java.util.stream.Collectors;


public class TypeOfMealConverter {


    public static TypeOfMealDTO convertToDTO(TypeOfMeal typeOfMeal) {
        return TypeOfMealDTO.builder()
                .id(typeOfMeal.getId())
                .typeMeals(typeOfMeal.getTypeMeals())
                .build();
    }

    public static TypeOfMeal convertFromDTO(TypeOfMealDTO typeOfMealDTO) {
        return TypeOfMeal.builder()
                .id(typeOfMealDTO.getId())
                .typeMeals(typeOfMealDTO.getTypeMeals())
                .build();
    }

    // zmapowalem BodyTYpe na liste BodyTYpeDto zeby latwiej wykorzystywac solid, Single resposibility converter do mapowania, controler to fasada z opakowującymi metodami
    public static List<TypeOfMealDTO> mapToListDto(List<TypeOfMeal> typeOfMealsList) {
        return typeOfMealsList.stream()
                .map(TypeOfMealConverter::convertToDTO)
                .collect(Collectors.toList());
    }


}
