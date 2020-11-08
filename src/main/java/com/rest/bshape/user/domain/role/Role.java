package com.rest.bshape.user.domain.role;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;


}
