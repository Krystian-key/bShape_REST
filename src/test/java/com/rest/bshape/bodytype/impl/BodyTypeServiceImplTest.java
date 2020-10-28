package com.rest.bshape.bodytype.impl;

import com.rest.bshape.bodytype.BodyTypeRepository;
import com.rest.bshape.bodytype.domain.BodyType;
import com.rest.bshape.bodytype.domain.BodyTypeID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BodyTypeServiceImplTest {

    private final String message = "BodyType not found with id :1";

    private final Long id = 1L;

    @Mock
    private BodyTypeRepository bodyTypeRepository;

    @InjectMocks
    private BodyTypeServiceImpl bodyTypeServiceImpl;

    @Test
    void shouldThrowExceptionDuringUpdate() {

        given(bodyTypeRepository.findById(1L)).willReturn(Optional.empty());
        BodyType bodyType = new BodyType();

        BodyType bodyTypeParam = new BodyType(id, "skinny");

        assertThatThrownBy(() -> bodyTypeServiceImpl.update(bodyTypeParam, id))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage(message);
    }

    @Test
    void shouldUpdateBodyType() {
        BodyType bodyType = new BodyType();
        given(bodyTypeRepository.save(any())).willReturn(bodyType);
        given(bodyTypeRepository.findById(id)).willReturn(Optional.of(bodyType));

        BodyType result = bodyTypeServiceImpl.update(bodyType, id);
        assertThat(result).isEqualTo(bodyType);
    }

    @Test
    void shouldReturnValueForFindById() {
        BodyType bodyType = new BodyType();
        given(bodyTypeRepository.findById(id)).willReturn(Optional.of(bodyType));

        BodyType result = bodyTypeServiceImpl.findById(id);
        assertThat(result).isEqualTo(bodyType);
    }

    @Test
    void shouldFindAllBodyTypes() {
        BodyType bodyType = new BodyType();
        given(bodyTypeRepository.findAll()).willReturn(Collections.singletonList(bodyType));

        List<BodyType> result = bodyTypeServiceImpl.findAll();
        assertThat(result).hasSize(1).contains(bodyType);
    }

    @Test
    void shouldFindEmptyBodyTypes() {
        given(bodyTypeRepository.findAll()).willReturn(Collections.emptyList());

        List<BodyType> result = bodyTypeServiceImpl.findAll();
        assertThat(result).isEmpty();
    }

    @Test
    void shouldCreateBodyType() {
        BodyType bodyType = new BodyType();
        bodyType.setId(1L);
        given(bodyTypeRepository.save(any())).willReturn(bodyType);

        BodyTypeID result = bodyTypeServiceImpl.create(bodyType);
        assertThat(result).isEqualTo(new BodyTypeID(1L));
    }

    @Test
    void shouldDeleteBodType() {

        doNothing().when(bodyTypeRepository).deleteById(any());
        bodyTypeServiceImpl.delete(id);
        verify(bodyTypeRepository, times(1)).deleteById(id);
    }

    @Test
    void shouldThrowExceptionDuringDeleteById() {

        doThrow(EmptyResultDataAccessException.class).when(bodyTypeRepository).deleteById(any());
        assertThatThrownBy(() -> bodyTypeServiceImpl.delete(any())).isInstanceOf(EmptyResultDataAccessException.class);
    }
}
