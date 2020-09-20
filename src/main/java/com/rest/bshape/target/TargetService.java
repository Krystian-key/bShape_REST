package com.rest.bshape.target;


import com.rest.bshape.target.domain.Target;
import com.rest.bshape.target.domain.TargetID;

import java.util.List;

public interface TargetService {
    List<Target> findAll();

    Target findById(Long id);

    TargetID create(Target target);

    Target update(Target target, Long id);

    void delete(Long id);

}
