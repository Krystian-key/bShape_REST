package com.rest.bshape.usertarget;

import com.rest.bshape.exception.ResourceNotFoundException;
import com.rest.bshape.usertarget.domain.UserTargetDTO;
import com.rest.bshape.usertarget.domain.UserTargetID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rest.bshape.usertarget.converter.UserTargetConverter.*;

@RestController
@RequestMapping("/api/user-target")
@CrossOrigin(origins = "http://localhost:4200")
class UserTargetController {

    private final UserTargetService userTargetService;

    public UserTargetController(UserTargetService userTargetService) {
        this.userTargetService = userTargetService;
    }

    @GetMapping
    public List<UserTargetDTO> findAll() {
        return mapToListDto(userTargetService.findAll());
    }


    @GetMapping("/{id}")
    public UserTargetDTO findById(@PathVariable Long id) {
        return convertToDTO(userTargetService.findById(id));
    }

    @PostMapping
    public UserTargetID create(@RequestBody UserTargetDTO userTargetDTO) {
        return userTargetService.create(convertFromDTO(userTargetDTO));
    }


    @PutMapping("/{id}")
    public UserTargetDTO update(@RequestBody UserTargetDTO userTargetDTO, @PathVariable("id") Long id) {
        return convertToDTO(userTargetService.update(convertFromDTO(userTargetDTO), id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userTargetService.delete(id);
    }
}
