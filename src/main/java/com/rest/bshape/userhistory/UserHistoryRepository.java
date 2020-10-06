package com.rest.bshape.userhistory;

import com.rest.bshape.userhistory.domain.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:4200")
public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
