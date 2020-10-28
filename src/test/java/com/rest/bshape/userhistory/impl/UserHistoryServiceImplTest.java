package com.rest.bshape.userhistory.impl;

import com.rest.bshape.userhistory.UserHistoryRepository;
import com.rest.bshape.userhistory.domain.UserHistory;
import com.rest.bshape.userhistory.domain.UserHistoryID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Optional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserHistoryServiceImplTest {

    private final String message = "UserHistory not found with id :1";

    private final Long id = 1L;

    @Mock
    UserHistoryRepository userHistoryRepository;

    @InjectMocks
    UserHistoryServiceImpl userHistoryServiceImpl;

    @Test
    void shouldThrowExceptionDuringUpdate() {
        given(userHistoryRepository.findById(1L)).willReturn(Optional.empty());
        UserHistory userHistory = new UserHistory();

        UserHistory userHistoryParam = UserHistory.builder()
                .id(id)
                .build();

        assertThatThrownBy(() -> userHistoryServiceImpl.update(userHistoryParam, id))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage(message);
    }

    @Test
    void shouldUpdateUserHistory() {
        UserHistory userHistory = new UserHistory();
        given(userHistoryRepository.save(any())).willReturn(userHistory);
        given(userHistoryRepository.findById(id)).willReturn(Optional.of(userHistory));

        UserHistory result = userHistoryServiceImpl.update(userHistory, id);
        assertThat(result).isEqualTo(userHistory);
    }

    @Test
    void shouldReturnValueForFindById() {
        UserHistory userHistory = new UserHistory();
        given(userHistoryRepository.findById(id)).willReturn(Optional.of(userHistory));

        UserHistory result = userHistoryServiceImpl.findById(id);
        assertThat(result).isEqualTo(userHistory);
    }

    @Test
    void shouldFindAllUserHistory() {
        UserHistory userHistory = new UserHistory();
        given(userHistoryRepository.findAll()).willReturn(Collections.singletonList(userHistory));
        List<UserHistory> result = userHistoryServiceImpl.findAll();
        assertThat(result).hasSize(1).contains(userHistory);
    }

    @Test
    void shouldFindEmptyUserHistory() {
        given(userHistoryRepository.findAll()).willReturn(Collections.emptyList());

        List<UserHistory> result = userHistoryServiceImpl.findAll();
        assertThat(result).isEmpty();
    }

    @Test
    void shouldCreateUserHistory() {
        UserHistory userHistory = new UserHistory();
        userHistory.setId(id);
        given(userHistoryRepository.save(any())).willReturn(userHistory);

        UserHistoryID result = userHistoryServiceImpl.create(userHistory);
        assertThat(result).isEqualTo(new UserHistoryID(id));
    }

    @Test
    void shouldDeleteUserHistory() {
        doNothing().when(userHistoryRepository).deleteById(any());
        userHistoryServiceImpl.delete(id);
        verify(userHistoryRepository, times(1)).deleteById(id);
    }

    @Test
    void shouldThrowExceptionDuringDeleteById() {
        doThrow(EmptyResultDataAccessException.class).when(userHistoryRepository).deleteById(any());
        assertThatThrownBy(() -> userHistoryServiceImpl.delete(any())).isInstanceOf(EmptyResultDataAccessException.class);
    }

}
