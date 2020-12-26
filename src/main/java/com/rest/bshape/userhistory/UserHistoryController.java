package com.rest.bshape.userhistory;

import com.rest.bshape.userhistory.domain.UserHistoryDTO;
import com.rest.bshape.userhistory.domain.UserHistoryID;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.rest.bshape.userhistory.converter.UserHistoryConverter.*;

@RestController
@RequestMapping("/api/user-history")
class UserHistoryController {

    private final UserHistoryService userHistoryService;

    public UserHistoryController(UserHistoryService userHistoryService) {
        this.userHistoryService = userHistoryService;
    }

    @GetMapping
    public List<UserHistoryDTO> findAll() {
        return mapToListDto(userHistoryService.findAll());
    }


    @GetMapping("/{id}")
    public UserHistoryDTO findById(@PathVariable Long id) {
        return convertToDTO(userHistoryService.findById(id));
    }

    @PostMapping
    public UserHistoryID create(@RequestBody @Valid UserHistoryDTO userHistoryDTO) {
        return userHistoryService.create(convertFromDTO(userHistoryDTO));
    }


    @PutMapping("/{id}")
    public UserHistoryDTO update(@RequestBody UserHistoryDTO userHistoryDTO, @PathVariable("id") Long id) {
        return convertToDTO(userHistoryService.update(convertFromDTO(userHistoryDTO), id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userHistoryService.delete(id);
    }
}
