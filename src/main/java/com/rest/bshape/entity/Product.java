package com.rest.bshape.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double gigajoule;
    private Double alkohol;
    private Double calories;
    private Double protein;
    private Double fat;
    private Double carbohydrates;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Meal> meals;
}