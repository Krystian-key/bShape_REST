package com.rest.bshape.user;


import com.rest.bshape.user.domain.UserDTO;
import com.rest.bshape.user.domain.UserID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.rest.bshape.user.converter.UserConverter.*;


@RestController
@RequestMapping("/api/user")  // linki kebab keysem i api bo to restowe i musze to oznaczyc + mozna wersje api
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
class UserController {

    private final UserService userService;


    @GetMapping
    public List<UserDTO> findAll() {

        return mapToListDto(userService.findAll());
    }


    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {  // nie muszę pisac value=id poniewaz nazwa zmiennej oznaczona adnotacją pathVariable jest taka sama jak nazwa zmiennej w klamnrach z 26
        return convertToDTO(userService.findById(id));

    }

    @PostMapping
    public UserID create(@RequestBody @Valid UserDTO userDTO) { //valid = włącza walidacje na klasie dto
        return userService.create(convertFromDTO(userDTO));
    }


    @PutMapping("/{id}")
    public UserDTO update(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        return convertToDTO(userService.update(convertFromDTO(userDTO), id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
