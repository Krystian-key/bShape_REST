package com.rest.bshape.controller;

import com.rest.bshape.dto.UserDTO;
import com.rest.bshape.dto.UserID;
import com.rest.bshape.entity.User;
import com.rest.bshape.exeption.ResourceNotFoundException;
import com.rest.bshape.sevices.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable(value = "id") Long id) {
        return userService.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
    }

    @PostMapping
    public UserID create(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO).orElseThrow(() -> new ResourceNotFoundException("User not created"));
    }

    @PutMapping("/{id}")
    public UserDTO update(@RequestBody UserDTO userDTO, @PathVariable("id") Long id) {
        return userService.update(userDTO, id).orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") Long id) {
        return this.userService.delete(id);
    }

    @GetMapping("/login")
    public ResponseEntity<User> getLogin(@RequestBody User user) {
        return userService.getLogin(user).isPresent() ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
