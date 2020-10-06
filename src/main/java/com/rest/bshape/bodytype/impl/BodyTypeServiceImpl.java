package com.rest.bshape.bodytype.impl;

import com.rest.bshape.bodytype.BodyTypeRepository;
import com.rest.bshape.bodytype.BodyTypeService;
import com.rest.bshape.bodytype.domain.BodyType;
import com.rest.bshape.bodytype.domain.BodyTypeID;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BodyTypeServiceImpl implements BodyTypeService {

    private final BodyTypeRepository bodyTypeRepository;
    private static final String MESSAGE_ERO_NOT_FOUND= "BodyType not found with id :";

    public BodyTypeServiceImpl(BodyTypeRepository bodyTypeRepository) {
        this.bodyTypeRepository = bodyTypeRepository;
    }

    @Override
    public List<BodyType> findAll() {
        return bodyTypeRepository.findAll();

    }

    @Override
    public BodyType findById(Long id) {
        return bodyTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MESSAGE_ERO_NOT_FOUND + id));
    }

    @Override
    public BodyTypeID create(BodyType bodyType) {
        bodyType = bodyTypeRepository.save(bodyType);
        return new BodyTypeID(bodyType.getId());
    }


    @Override
    public BodyType update(BodyType bodyType, Long id) {

        BodyType bodyTypeById = bodyTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MESSAGE_ERO_NOT_FOUND + id));

        bodyTypeById.setTypeOfBody(bodyType.getTypeOfBody());
        return bodyTypeRepository.save(bodyTypeById);
    }


    @Override
    public void delete(Long id) {
        bodyTypeRepository.deleteById(id);
    }


}
