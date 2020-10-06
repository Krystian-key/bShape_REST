package com.rest.bshape.userTarget;

import com.rest.bshape.exception.ResourceNotFoundException;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserTargetService {

    private final UserTargetRepository userTargetRepository;

    public UserTargetService(UserTargetRepository userTargetRepository) {
        this.userTargetRepository = userTargetRepository;
    }

    public List<UserTargetDTO> findAll() {
        List<UserTarget> optionalTarget = this.userTargetRepository.findAll();
        return optionalTarget.isEmpty() ? Collections.emptyList() : optionalTarget.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserTargetDTO> findById(Long id) {
        Optional<UserTarget> optionalTarget = userTargetRepository.findById(id);
        return optionalTarget.isEmpty() ? Optional.empty() : optionalTarget.map(this::convertToDTO);
    }

    public Optional<UserTargetID> create(UserTargetDTO userTargetDTO) {
        UserTarget target = this.convertFromDTO(userTargetDTO);

        UserTarget createdTarget = userTargetRepository.save(target);
        val targetID = new UserTargetID(createdTarget.getId());
        return Optional.of(targetID);
    }

    public Optional<UserTargetDTO> update(UserTargetDTO userTargetDTO, Long id) {
        UserTarget target = this.convertFromDTO(userTargetDTO);

        Optional<UserTarget> targetById = userTargetRepository.findById(id);
        if (targetById.isEmpty()) {
            return Optional.empty();
        }
        UserTarget existingTarget = targetById.get();
        existingTarget.setFutureTarget(target.getFutureTarget());
        return Optional.of(this.convertToDTO(userTargetRepository.save(existingTarget)));
    }

    public ResponseEntity<UserTargetID> delete(Long id) {
        UserTarget existingTarget = this.userTargetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Target not found with id:" + id));
        this.userTargetRepository.delete(existingTarget);
        return ResponseEntity.ok().build();
    }

    private UserTargetDTO convertToDTO(UserTarget target) {
        return UserTargetDTO.builder()
                .id(target.getId())
                .futureTarget(target.getFutureTarget())
                .build();
    }

    private UserTarget convertFromDTO(UserTargetDTO userTargetDTO) {
        return UserTarget.builder()
                .id(userTargetDTO.getId())
                .futureTarget(userTargetDTO.getFutureTarget())
                .build();
    }
}
