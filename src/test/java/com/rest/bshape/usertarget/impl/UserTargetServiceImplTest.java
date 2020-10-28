package com.rest.bshape.usertarget.impl;



import com.rest.bshape.usertarget.UserTargetRepository;
import com.rest.bshape.usertarget.domain.UserTarget;
import com.rest.bshape.usertarget.domain.UserTargetID;
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
class UserTargetServiceImplTest {

    private final String message = "User Target not found with id :1";

    private final Long id = 1L;

    @Mock
    UserTargetRepository userTargetRepository;

    @InjectMocks
    UserTargetServiceImpl userTargetServiceImpl;

    @Test
    void shouldThrowExceptionDuringUpdate() {
        given(userTargetRepository.findById(id)).willReturn(Optional.empty());
        UserTarget userTarget = new UserTarget();

        UserTarget userTargetParam = userTarget.builder()
                .id(id)
                .build();

        assertThatThrownBy(() -> userTargetServiceImpl.update(userTargetParam, id))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage(message);
    }

    @Test
    void shouldUpdateUserTarget() {
        UserTarget userTarget = new UserTarget();
        given(userTargetRepository.save(any())).willReturn(userTarget);
        given(userTargetRepository.findById(id)).willReturn(Optional.of(userTarget));

        UserTarget result = userTargetServiceImpl.update(userTarget, id);
        assertThat(result).isEqualTo(userTarget);

    }

    @Test
    void shouldReturnValueForFindById() {
        UserTarget userTarget = new UserTarget();
        given(userTargetRepository.findById(id)).willReturn(Optional.of(userTarget));

        UserTarget result = userTargetServiceImpl.findById(id);
        assertThat(result).isEqualTo(userTarget);
    }

    @Test
    void shouldFindAllUserTarget() {
        UserTarget userTarget = new UserTarget();
        given(userTargetRepository.findAll()).willReturn(Collections.singletonList(userTarget));
        List<UserTarget> result = userTargetServiceImpl.findAll();
        assertThat(result).hasSize(1).contains(userTarget);
    }

    @Test
    void shouldFindEmptyUserTarget() {
        given(userTargetRepository.findAll()).willReturn(Collections.emptyList());

        List<UserTarget> result = userTargetServiceImpl.findAll();
        assertThat(result).isEmpty();
    }

    @Test
    void shouldCreateUserTarget() {
        UserTarget userTarget = new UserTarget();
        userTarget.setId(id);
        given(userTargetRepository.save(any())).willReturn(userTarget);

        UserTargetID result = userTargetServiceImpl.create(userTarget);
        assertThat(result).isEqualTo(new UserTargetID(id));
    }

    @Test
    void shouldDeleteUserTarget() {
        doNothing().when(userTargetRepository).deleteById(any());
        userTargetServiceImpl.delete(id);
        verify(userTargetRepository, times(1)).deleteById(id);
    }

    @Test
    void shouldThrowExceptionDuringDeleteById() {
        doThrow(EmptyResultDataAccessException.class).when(userTargetRepository).deleteById(any());
        assertThatThrownBy(() -> userTargetServiceImpl.delete(any())).isInstanceOf(EmptyResultDataAccessException.class);
    }
}
