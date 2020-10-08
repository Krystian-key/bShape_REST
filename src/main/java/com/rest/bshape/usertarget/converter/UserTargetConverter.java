package com.rest.bshape.usertarget.converter;

import com.rest.bshape.usertarget.domain.UserTarget;
import com.rest.bshape.usertarget.domain.UserTargetDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserTargetConverter {

    private UserTargetConverter() {
    }

    public static UserTargetDTO convertToDTO(UserTarget target) {
        return UserTargetDTO.builder()
                .id(target.getId())
                .futureTarget(target.getFutureTarget())
                .build();
    }

    public static UserTarget convertFromDTO(UserTargetDTO userTargetDTO) {
        return UserTarget.builder()
                .id(userTargetDTO.getId())
                .futureTarget(userTargetDTO.getFutureTarget())
                .build();
    }

    public static List<UserTargetDTO> mapToListDto(List<UserTarget> userTargets) {
        return userTargets.stream()
                .map(UserTargetConverter::convertToDTO)
                .collect(Collectors.toList());
    }
}
