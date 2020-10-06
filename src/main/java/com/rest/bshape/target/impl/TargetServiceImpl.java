package com.rest.bshape.target.impl;

import com.rest.bshape.target.TargetRepository;
import com.rest.bshape.target.TargetService;
import com.rest.bshape.target.domain.Target;
import com.rest.bshape.target.domain.TargetID;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TargetServiceImpl implements TargetService {


    private final TargetRepository targetRepository;

    public TargetServiceImpl(TargetRepository targetRepository) {
        this.targetRepository = targetRepository;
    }

    @Override
    public List<Target> findAll() {
        return this.targetRepository.findAll();
    }

    @Override
    public Target findById(Long id) {
        return targetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BodyType not found with id :" + id));
    }

    @Override
    public TargetID create(Target target) {
        target = targetRepository.save(target);
        return new TargetID(target.getId());
    }


    @Override
    public Target update(Target target, Long id) {

        Target targetById = targetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BodyType not found with id :" + id));

        targetById.setFutureTarget(target.getFutureTarget());
        return targetRepository.save(targetById);
    }


    @Override
    public void delete(Long id) {
        this.targetRepository.deleteById(id);
    }

}
