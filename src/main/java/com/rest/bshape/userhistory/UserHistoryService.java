package com.rest.bshape.userhistory;

import com.rest.bshape.userhistory.domain.UserHistory;
import com.rest.bshape.userhistory.domain.UserHistoryID;

import java.util.List;


public interface UserHistoryService {

    List<UserHistory> findAll();

    UserHistory findById(Long id);

    UserHistoryID create(UserHistory userHistory);

    UserHistory update(UserHistory userHistory, Long id);

    void delete(Long id);
}
