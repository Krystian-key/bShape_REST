package com.rest.bshape.usertarget;

import com.rest.bshape.usertarget.domain.UserTarget;
import com.rest.bshape.usertarget.domain.UserTargetID;

import java.util.List;


public interface UserTargetService {

    List<UserTarget> findAll();

    UserTarget findById(Long id);

    UserTargetID create(UserTarget userTarget);

    UserTarget update(UserTarget userTarget, Long id);

    void delete(Long id);
}
