package com.rest.bshape.meal.domain;

import com.rest.bshape.product.domain.Product;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Setter
@Getter
@Builder (toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String mealName;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Product> products;
}
