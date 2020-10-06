package com.rest.bshape.userhistory.converter;

import com.rest.bshape.userhistory.domain.UserHistory;
import com.rest.bshape.userhistory.domain.UserHistoryDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserHistoryConverter {

    public static UserHistoryDTO convertToDTO(UserHistory userHistory) {
        return UserHistoryDTO.builder()
                .id(userHistory.getId())
                .alcoholEaten(userHistory.getAlcoholEaten())
                .alcoholSchedule(userHistory.getAlcoholSchedule())
                .caloriesEaten(userHistory.getCaloriesEaten())
                .caloriesSchedule(userHistory.getCaloriesSchedule())
                .carbohydratesEaten(userHistory.getCarbohydratesEaten())
                .carbohydratesSchedule(userHistory.getCarbohydratesSchedule())
                .date(userHistory.getDate())
                .fatEaten(userHistory.getFatEaten())
                .fatSchedule(userHistory.getFatSchedule())
                .gigajouleEaten(userHistory.getGigajouleEaten())
                .gigajouleSchedule(userHistory.getGigajouleSchedule())
                .proteinEaten(userHistory.getProteinEaten())
                .proteinSchedule(userHistory.getProteinSchedule())
                .weight(userHistory.getWeight())
                .build();
    }


    public static UserHistory convertFromDTO(UserHistoryDTO userHistoryDTO) {
        return UserHistory.builder()
                .id(userHistoryDTO.getId())
                .alcoholEaten(userHistoryDTO.getAlcoholEaten())
                .alcoholSchedule(userHistoryDTO.getAlcoholSchedule())
                .caloriesEaten(userHistoryDTO.getCaloriesEaten())
                .caloriesSchedule(userHistoryDTO.getCaloriesSchedule())
                .carbohydratesEaten(userHistoryDTO.getCarbohydratesEaten())
                .carbohydratesSchedule(userHistoryDTO.getCarbohydratesSchedule())
                .date(userHistoryDTO.getDate())
                .fatEaten(userHistoryDTO.getFatEaten())
                .fatSchedule(userHistoryDTO.getFatSchedule())
                .gigajouleEaten(userHistoryDTO.getGigajouleEaten())
                .gigajouleSchedule(userHistoryDTO.getGigajouleSchedule())
                .proteinEaten(userHistoryDTO.getProteinEaten())
                .proteinSchedule(userHistoryDTO.getProteinSchedule())
                .weight(userHistoryDTO.getWeight())
                .build();
    }

    public static List<UserHistoryDTO> mapToListDto(List<UserHistory> userHistories) {
        return userHistories.stream()
                .map(UserHistoryConverter::convertToDTO)
                .collect(Collectors.toList());
    }
}
