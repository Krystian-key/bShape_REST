package com.rest.bshape.userTarget;

import com.rest.bshape.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/target")
@CrossOrigin(origins = "http://localhost:4200")
class UserTargetController {

    private final UserTargetService userTargetService;

    public UserTargetController(UserTargetService userTargetService) {
        this.userTargetService = userTargetService;
    }

    @GetMapping
    public List<UserTargetDTO> findAll() {
        return this.userTargetService.findAll();
    }


    @GetMapping("/{id}")
    public UserTargetDTO findById(@PathVariable(value = "id") Long id) {
        return userTargetService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Target not found with id :" + id));
    }

    @PostMapping
    public UserTargetID create(@RequestBody UserTargetDTO userTargetDTO) {
        return userTargetService.create(userTargetDTO).orElseThrow(() -> new ResourceNotFoundException("Target not created"));
    }


    @PutMapping("/{id}")
    public UserTargetDTO update(@RequestBody UserTargetDTO userTargetDTO, @PathVariable("id") Long id) {
        return userTargetService.update(userTargetDTO, id).orElseThrow(() -> new ResourceNotFoundException("Target not found with id :" + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserTargetID> delete(@PathVariable("id") Long id) {
        return this.userTargetService.delete(id);
    }
}
