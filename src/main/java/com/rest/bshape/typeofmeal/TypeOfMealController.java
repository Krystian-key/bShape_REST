package com.rest.bshape.typeofmeal;


import com.rest.bshape.typeofmeal.domain.TypeOfMealDTO;
import com.rest.bshape.typeofmeal.domain.TypeOfMealID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.rest.bshape.typeofmeal.converter.TypeOfMealConverter.*;


@RestController
@RequestMapping("/typeOfMeals")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class TypeOfMealController {

    private final TypeOfMealService typeOfMealService;


    @GetMapping
    public List<TypeOfMealDTO> findAll() {

        return mapToListDto(typeOfMealService.findAll());
    }


    @GetMapping("/{id}")
    public TypeOfMealDTO findById(@PathVariable Long id) {  // nie muszę pisac value=id poniewaz nazwa zmiennej oznaczona adnotacją pathVariable jest taka sama jak nazwa zmiennej w klamnrach z 26
        return convertToDTO(typeOfMealService.findById(id));

    }

    @PostMapping
    public TypeOfMealID create(@RequestBody @Valid TypeOfMealDTO typeOfMealDTO) { //valid = włącza walidacje na klasie dto
        return typeOfMealService.create(convertFromDTO(typeOfMealDTO));
    }


    @PutMapping("/{id}")
    public TypeOfMealDTO update(@RequestBody TypeOfMealDTO typeOfMealDTO, @PathVariable Long id) {
        return convertToDTO(typeOfMealService.update(convertFromDTO(typeOfMealDTO), id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        typeOfMealService.delete(id);
    }

}
