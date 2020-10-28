package com.rest.bshape.typeofmeal.impl;

import com.rest.bshape.typeofmeal.TypeOfMealRepository;
import com.rest.bshape.typeofmeal.domain.TypeOfMeal;
import com.rest.bshape.typeofmeal.domain.TypeOfMealID;
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
class TypeOfMealServiceImplTest {

    private final String message = "TypeOfMeal not found with id :1";

    private final Long id = 1L;

    @Mock
    private TypeOfMealRepository typeOfMealRepository;

    @InjectMocks
    private TypeOfMealServiceImpl typeOfMealService;

    @Test
    void shouldThrowExceptionDuringUpdate() {

        given(typeOfMealRepository.findById(id)).willReturn(Optional.empty());
        TypeOfMeal typeOfMeal = new TypeOfMeal();

        TypeOfMeal typeOfMealParam = TypeOfMeal.builder()
                .id(id)
                .build();

        assertThatThrownBy(() -> typeOfMealService.update(typeOfMealParam, id))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage(message);
    }

    @Test
    void shouldUpdateTypeOfMeal() {
        TypeOfMeal typeOfMeal = new TypeOfMeal();
        given(typeOfMealRepository.save(any())).willReturn(typeOfMeal);
        given(typeOfMealRepository.findById(id)).willReturn(Optional.of(typeOfMeal));

        TypeOfMeal result = typeOfMealService.update(typeOfMeal, id);
        assertThat(result).isEqualTo(typeOfMeal);
    }

    @Test
    void shouldReturnValueForFindById() {
        TypeOfMeal typeOfMeal = new TypeOfMeal();
        given(typeOfMealRepository.findById(id)).willReturn(Optional.of(typeOfMeal));

        TypeOfMeal result = typeOfMealService.findById(id);
        assertThat(result).isEqualTo(typeOfMeal);
    }

    @Test
    void shouldFindAllTypesOfMeal() {
        TypeOfMeal typeOfMeal = new TypeOfMeal();
        given(typeOfMealRepository.findAll()).willReturn(Collections.singletonList(typeOfMeal));
        List<TypeOfMeal> result = typeOfMealService.findAll();
        assertThat(result).hasSize(1).contains(typeOfMeal);
    }

    @Test
    void shouldFindEmptyBodyTypes() {
        given(typeOfMealRepository.findAll()).willReturn(Collections.emptyList());

        List<TypeOfMeal> result = typeOfMealService.findAll();
        assertThat(result).isEmpty();

    }

    @Test
    void shouldCreateTypeOfMeal() {
        TypeOfMeal typeOfMeal = TypeOfMeal.builder()
                .id(id)
                .build();
        given(typeOfMealRepository.save(any())).willReturn(typeOfMeal);

        TypeOfMealID result = typeOfMealService.create(typeOfMeal);
        assertThat(result).isEqualTo(new TypeOfMealID(id));
    }

    @Test
    void shouldDeleteTypeOfMeal() {
        doNothing().when(typeOfMealRepository).deleteById(any());
        typeOfMealService.delete(id);
        verify(typeOfMealRepository, times(1)).deleteById(id);
    }

    @Test
    void shouldThrowExceptionDuringDeleteById() {

        doThrow(EmptyResultDataAccessException.class).when(typeOfMealRepository).deleteById(any());
        assertThatThrownBy(() -> typeOfMealService.delete(any())).isInstanceOf(EmptyResultDataAccessException.class);
    }
}
