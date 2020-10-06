package com.rest.bshape.target.converter;


import com.rest.bshape.target.domain.Target;
import com.rest.bshape.target.domain.TargetDTO;

import java.util.List;
import java.util.stream.Collectors;


public class TargetConverter {

    public static TargetDTO convertToDTO(Target target) {
        return TargetDTO.builder()
                .id(target.getId())
                .futureTarget(target.getFutureTarget())
                .build();
    }

    public static Target convertFromDTO(TargetDTO targetDTO) {
        return Target.builder()
                .id(targetDTO.getId())
                .futureTarget(targetDTO.getFutureTarget())
                .build();
    }

    public static List<TargetDTO> mapToListDto(List<Target> targetList) {
        return targetList.stream()
                .map(TargetConverter::convertToDTO)
                .collect(Collectors.toList());
    }


}
