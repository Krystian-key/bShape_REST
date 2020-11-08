package com.rest.bshape.userhistory.impl;

import com.rest.bshape.userhistory.UserHistoryRepository;
import com.rest.bshape.userhistory.UserHistoryService;
import com.rest.bshape.userhistory.domain.UserHistory;
import com.rest.bshape.userhistory.domain.UserHistoryID;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
class UserHistoryServiceImpl implements UserHistoryService {

    private final UserHistoryRepository userHistoryRepository;
    private static final String MESSAGE_ERO_NOT_FOUND = "UserHistory not found with id :";

    UserHistoryServiceImpl(UserHistoryRepository userHistoryRepository) {
        this.userHistoryRepository = userHistoryRepository;
    }

    @Override
    public List<UserHistory> findAll() {
        return userHistoryRepository.findAll();
    }

    @Override
    public UserHistory findById(Long id) {
        return userHistoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MESSAGE_ERO_NOT_FOUND + id));
    }

    @Override
    public UserHistoryID create(UserHistory userHistory) {
        userHistory = userHistoryRepository.save(userHistory);
        return new UserHistoryID(userHistory.getId());
    }


    @Override
    public UserHistory update(UserHistory userHistory, Long id) {

        return userHistoryRepository.save(findById(id)
                .toBuilder()
                .date(userHistory.getDate())
                .weight(userHistory.getWeight())
                .alcoholEaten(userHistory.getAlcoholEaten())
                .alcoholSchedule(userHistory.getAlcoholSchedule())
                .caloriesEaten(userHistory.getCaloriesEaten())
                .caloriesSchedule(userHistory.getCaloriesSchedule())
                .carbohydratesEaten(userHistory.getCarbohydratesEaten())
                .carbohydratesSchedule(userHistory.getCarbohydratesSchedule())
                .fatEaten(userHistory.getFatEaten())
                .fatSchedule(userHistory.getFatSchedule())
                .gigajouleEaten(userHistory.getGigajouleEaten())
                .gigajouleSchedule(userHistory.getGigajouleSchedule())
                .proteinEaten(userHistory.getProteinEaten())
                .proteinSchedule(userHistory.getProteinSchedule())
                .build());
    }

    @Override
    public void delete(Long id) {
        userHistoryRepository.deleteById(id);
    }
}
