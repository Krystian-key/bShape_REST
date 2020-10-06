package com.rest.bshape.userTarget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserTargetDTO {

    private Long id;

    private String futureTarget;
}
