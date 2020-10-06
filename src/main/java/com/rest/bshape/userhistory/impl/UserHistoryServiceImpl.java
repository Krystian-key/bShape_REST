package com.rest.bshape.userhistory.impl;

import com.rest.bshape.bodytype.domain.BodyType;
import com.rest.bshape.userhistory.UserHistoryRepository;
import com.rest.bshape.userhistory.UserHistoryService;
import com.rest.bshape.userhistory.domain.UserHistory;
import com.rest.bshape.userhistory.domain.UserHistoryID;

import java.util.List;

class UserHistoryServiceImpl implements UserHistoryService {

    private final UserHistoryRepository userHistoryRepository;

    UserHistoryServiceImpl(UserHistoryRepository userHistoryRepository) {
        this.userHistoryRepository = userHistoryRepository;
    }

    @Override
    public List<UserHistory> findAll() {
        return userHistoryRepository.findAll();
    }

    @Override
    public BodyType findById(Long id) {
        return null;
    }

    @Override
    public UserHistoryID create(UserHistory userHistory) {
        return null;
    }

    @Override
    public UserHistory update(UserHistory userHistory, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
