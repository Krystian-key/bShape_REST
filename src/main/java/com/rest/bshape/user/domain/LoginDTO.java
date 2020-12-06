package com.rest.bshape.user.domain;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@NoArgsConstructor
public class LoginDTO {

    private String email;

    private String password;
}
