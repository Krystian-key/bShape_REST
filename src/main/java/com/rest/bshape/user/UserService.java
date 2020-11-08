package com.rest.bshape.user;


import com.rest.bshape.user.domain.User;
import com.rest.bshape.user.domain.UserID;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    UserID create(User user);

    User update(User user, Long id);

    void delete(Long id);


}
