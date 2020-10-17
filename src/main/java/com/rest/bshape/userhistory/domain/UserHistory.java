package com.rest.bshape.userhistory.domain;

import com.rest.bshape.bodytype.domain.BodyType;
import com.rest.bshape.meal.domain.Meal;
//import com.rest.bshape.userTarget.UserTarget;
import com.rest.bshape.typeofmeal.domain.TypeOfMeal;
import com.rest.bshape.user.domain.User;
import com.rest.bshape.usertarget.domain.UserTarget;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
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

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Meal> meals;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private User users;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private BodyType bodyTypes;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private TypeOfMeal typeOfMeals;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private UserTarget targets;

}
