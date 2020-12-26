package com.rest.bshape.usertarget;

import com.rest.bshape.usertarget.domain.UserTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface UserTargetRepository extends JpaRepository<UserTarget, Long> {
}
