package com.rest.bshape.userhistory.domain;

import com.rest.bshape.bodytype.domain.BodyTypeDTO;
import com.rest.bshape.meal.domain.MealDTO;
import com.rest.bshape.typeofmeal.domain.TypeOfMealDTO;
import com.rest.bshape.user.UserDTO;
import com.rest.bshape.userTarget.UserTargetDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserHistoryDTO {

    private Long id;

    private LocalDate date;
    private Double weight;
    private Double alcoholEaten;
    private Double alcoholSchedule;
    private Double caloriesEaten;
    private Double caloriesSchedule;
    private Double carbohydratesEaten;
    private Double carbohydratesSchedule;
    private Double fatEaten;
    private Double fatSchedule;
    private Double gigajouleEaten;
    private Double gigajouleSchedule;
    private Double proteinEaten;
    private Double proteinSchedule;

    private List<MealDTO> mealDTO;

    private UserDTO userDTO;

    private BodyTypeDTO bodyTypeDTO;

    private TypeOfMealDTO typeOfMealDTO;

    private UserTargetDTO targetDTO;

}
