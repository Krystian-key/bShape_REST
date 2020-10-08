package com.rest.bshape.usertarget.impl;

import com.rest.bshape.usertarget.UserTargetRepository;
import com.rest.bshape.usertarget.UserTargetService;
import com.rest.bshape.usertarget.domain.UserTarget;
import com.rest.bshape.usertarget.domain.UserTargetID;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
class UserTargetServiceImpl implements UserTargetService {

    private final UserTargetRepository userTargetRepository;
    private static final String MESSAGE_ERO_NOT_FOUND = "User Target not found with id :";

    UserTargetServiceImpl(UserTargetRepository userTargetRepository) {
        this.userTargetRepository = userTargetRepository;
    }

    @Override
    public List<UserTarget> findAll() {
        return userTargetRepository.findAll();
    }

    @Override
    public UserTarget findById(Long id) {
        return userTargetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MESSAGE_ERO_NOT_FOUND + id));
    }

    @Override
    public UserTargetID create(UserTarget userTarget) {
        userTarget = userTargetRepository.save(userTarget);
        return new UserTargetID(userTarget.getId());
    }

    @Override
    public UserTarget update(UserTarget userTarget, Long id) {
        UserTarget userTargetById = userTargetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MESSAGE_ERO_NOT_FOUND + id));
        userTargetById.setFutureTarget(userTarget.getFutureTarget());
        return userTargetRepository.save(userTargetById);
    }

    @Override
    public void delete(Long id) {
        userTargetRepository.deleteById(id);
    }
}
