package com.rest.bshape.userhistory.domain;

import com.rest.bshape.bodytype.domain.BodyType;
import com.rest.bshape.meal.domain.Meal;
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
@Builder (toBuilder = true)  // z istniejącego obiektu User mogę stowrzyć builder który ma już ustawione odpowiednie pola, moge je nadpisać poprzez funckje
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

    public UserHistory setId(Long id) {
        this.id = id;
        return this;
    }

    public UserHistory setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public UserHistory setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public UserHistory setAlcoholEaten(Double alcoholEaten) {
        this.alcoholEaten = alcoholEaten;
        return this;
    }

    public UserHistory setAlcoholSchedule(Double alcoholSchedule) {
        this.alcoholSchedule = alcoholSchedule;
        return this;
    }

    public UserHistory setCaloriesEaten(Double caloriesEaten) {
        this.caloriesEaten = caloriesEaten;
        return this;
    }

    public UserHistory setCaloriesSchedule(Double caloriesSchedule) {
        this.caloriesSchedule = caloriesSchedule;
        return this;
    }

    public UserHistory setCarbohydratesEaten(Double carbohydratesEaten) {
        this.carbohydratesEaten = carbohydratesEaten;
        return this;
    }

    public UserHistory setCarbohydratesSchedule(Double carbohydratesSchedule) {
        this.carbohydratesSchedule = carbohydratesSchedule;
        return this;
    }

    public UserHistory setFatEaten(Double fatEaten) {
        this.fatEaten = fatEaten;
        return this;
    }

    public UserHistory setFatSchedule(Double fatSchedule) {
        this.fatSchedule = fatSchedule;
        return this;
    }

    public UserHistory setGigajouleEaten(Double gigajouleEaten) {
        this.gigajouleEaten = gigajouleEaten;
        return this;
    }

    public UserHistory setGigajouleSchedule(Double gigajouleSchedule) {
        this.gigajouleSchedule = gigajouleSchedule;
        return this;
    }

    public UserHistory setProteinEaten(Double proteinEaten) {
        this.proteinEaten = proteinEaten;
        return this;
    }

    public UserHistory setProteinSchedule(Double proteinSchedule) {
        this.proteinSchedule = proteinSchedule;
        return this;
    }

    public UserHistory setMeals(List<Meal> meals) {
        this.meals = meals;
        return this;
    }

    public UserHistory setUsers(User users) {
        this.users = users;
        return this;
    }

    public UserHistory setBodyTypes(BodyType bodyTypes) {
        this.bodyTypes = bodyTypes;
        return this;
    }

    public UserHistory setTypeOfMeals(TypeOfMeal typeOfMeals) {
        this.typeOfMeals = typeOfMeals;
        return this;
    }

    public UserHistory setTargets(UserTarget targets) {
        this.targets = targets;
        return this;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getAlcoholEaten() {
        return alcoholEaten;
    }

    public Double getAlcoholSchedule() {
        return alcoholSchedule;
    }

    public Double getCaloriesEaten() {
        return caloriesEaten;
    }

    public Double getCaloriesSchedule() {
        return caloriesSchedule;
    }

    public Double getCarbohydratesEaten() {
        return carbohydratesEaten;
    }

    public Double getCarbohydratesSchedule() {
        return carbohydratesSchedule;
    }

    public Double getFatEaten() {
        return fatEaten;
    }

    public Double getFatSchedule() {
        return fatSchedule;
    }

    public Double getGigajouleEaten() {
        return gigajouleEaten;
    }

    public Double getGigajouleSchedule() {
        return gigajouleSchedule;
    }

    public Double getProteinEaten() {
        return proteinEaten;
    }

    public Double getProteinSchedule() {
        return proteinSchedule;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public User getUsers() {
        return users;
    }

    public BodyType getBodyTypes() {
        return bodyTypes;
    }

    public TypeOfMeal getTypeOfMeals() {
        return typeOfMeals;
    }

    public UserTarget getTargets() {
        return targets;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Meal> meals;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private User users;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private BodyType bodyTypes;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private TypeOfMeal typeOfMeals;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private com.rest.bshape.usertarget.domain.UserTarget targets;

}
