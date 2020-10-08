package com.rest.bshape.usertarget.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserTargetDTO {

    private Long id;

    private String futureTarget;
}
