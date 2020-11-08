package com.rest.bshape.user.domain;

import com.rest.bshape.bodytype.domain.BodyTypeDTO;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private Double weight;

    private Double height;

    private Integer sex;

    private String password;

    private String email;

    private BodyTypeDTO bodyTypeDTO;
}
