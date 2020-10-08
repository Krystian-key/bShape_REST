package com.rest.bshape.usertarget;

import com.rest.bshape.usertarget.domain.UserTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface UserTargetRepository extends JpaRepository<UserTarget, Long> {
}
