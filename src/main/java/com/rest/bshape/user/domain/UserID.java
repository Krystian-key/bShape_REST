package com.rest.bshape.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class UserID {

    private final Long id;

}
