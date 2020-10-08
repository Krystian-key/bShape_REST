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

        UserHistory userHistoryById = userHistoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MESSAGE_ERO_NOT_FOUND + id));

        userHistoryById.setDate(userHistory.getDate());
        userHistoryById.setWeight(userHistory.getWeight());
        userHistoryById.setAlcoholEaten(userHistory.getAlcoholEaten());
        userHistoryById.setAlcoholSchedule(userHistory.getAlcoholSchedule());
        userHistoryById.setCaloriesEaten(userHistory.getCaloriesEaten());
        userHistoryById.setCaloriesSchedule(userHistory.getCaloriesSchedule());
        userHistoryById.setCarbohydratesEaten(userHistory.getCarbohydratesEaten());
        userHistoryById.setCarbohydratesSchedule(userHistory.getCarbohydratesSchedule());
        userHistoryById.setFatEaten(userHistory.getFatEaten());
        userHistoryById.setFatSchedule(userHistory.getFatSchedule());
        userHistoryById.setGigajouleEaten(userHistory.getGigajouleEaten());
        userHistoryById.setGigajouleSchedule(userHistory.getGigajouleSchedule());
        userHistoryById.setProteinEaten(userHistory.getProteinEaten());
        userHistoryById.setProteinSchedule(userHistory.getProteinSchedule());
        return userHistoryRepository.save(userHistoryById);
    }

    @Override
    public void delete(Long id) {
        userHistoryRepository.deleteById(id);
    }
}
