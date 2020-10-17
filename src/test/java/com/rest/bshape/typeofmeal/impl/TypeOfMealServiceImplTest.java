package com.rest.bshape.typeofmeal.impl;

import com.rest.bshape.typeofmeal.TypeOfMealRepository;
import com.rest.bshape.typeofmeal.domain.TypeOfMeal;
import com.rest.bshape.typeofmeal.domain.TypeOfMealID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    @Mock
    private TypeOfMealRepository typeOfMealRepository;
    @InjectMocks
    private TypeOfMealServiceImpl typeOfMealService;

    @Test
    void shouldThrowExceptionDuringUpdate() {

        given(typeOfMealRepository.findById(1L)).willReturn(Optional.empty());
        TypeOfMeal typeOfMeal = new TypeOfMeal();

        Long id = 1L;
        TypeOfMeal typeOfMealParam = TypeOfMeal.builder()
                .id(1L)
                .build();

        assertThatThrownBy(() -> typeOfMealService.update(typeOfMealParam, id))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("Type of meal not found with id :1");

    }

    @Test
    void shouldFindAllTypesOfMeal() {
        TypeOfMeal typeOfMeal = new TypeOfMeal();
        given(typeOfMealRepository.findAll()).willReturn(Collections.singletonList(typeOfMeal));
        List<TypeOfMeal> result = typeOfMealService.findAll();
        assertThat(result).hasSize(1).contains(typeOfMeal);
    }

    @Test
    void shouldReturnTypeOfMealForFindById() {
        TypeOfMeal typeOfMeal = new TypeOfMeal();
        given(typeOfMealRepository.findById(1L)).willReturn(Optional.of(typeOfMeal));

        TypeOfMeal result = typeOfMealService.findById(1L);
        assertThat(result).isEqualTo(typeOfMeal);

    }

    @Test
    void shouldCreateTypeOfMeal() {
        TypeOfMeal typeOfMeal = TypeOfMeal.builder()
                .id(1L)
                .build();
        given(typeOfMealRepository.save(any())).willReturn(typeOfMeal);

        TypeOfMealID result = typeOfMealService.create(typeOfMeal);
        assertThat(result).isEqualTo(new TypeOfMealID(1L));
    }

    @Test
    void shouldUpdateTypeOfMeal() {
        TypeOfMeal typeOfMeal = new TypeOfMeal();
        given(typeOfMealRepository.save(any())).willReturn(typeOfMeal);
        given(typeOfMealRepository.findById(1L)).willReturn(Optional.of(typeOfMeal));

        TypeOfMeal result = typeOfMealService.update(typeOfMeal, 1L);
        assertThat(result).isEqualTo(typeOfMeal);
    }

    @Test
    void shouldDeleteTypeOfMeal() {
        doNothing().when(typeOfMealRepository).deleteById(any());
        typeOfMealService.delete(1L);
        verify(typeOfMealRepository, times(1)).deleteById(1L);
    }
}