package com.rest.bshape.meal;

import com.rest.bshape.meal.domain.MealDTO;
import com.rest.bshape.meal.domain.MealID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.rest.bshape.meal.converter.MealConverter.*;

@RestController
@RequestMapping("/api/meal")  // linki kebab keysem i api bo to restowe i musze to oznaczyc + mozna wersje api
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
class MealController {

    private final MealService mealService;

    @GetMapping
    public List<MealDTO> findAll() {

        return mapToListDto(mealService.findAll());
    }

    @GetMapping("/{id}")
    public MealDTO findById(@PathVariable Long id) {  // nie muszę pisac value=id poniewaz nazwa zmiennej oznaczona adnotacją pathVariable jest taka sama jak nazwa zmiennej w klamnrach z 26
        return convertToDTO(mealService.findById(id));

    }

    @PostMapping
    public MealID create(@RequestBody @Valid MealDTO mealDTO) { //valid = włącza walidacje na klasie dto
        return mealService.create(convertFromDTO(mealDTO));
    }


    @PutMapping("/{id}")
    public MealDTO update(@RequestBody MealDTO mealDTO, @PathVariable Long id) {
        return convertToDTO(mealService.update(convertFromDTO(mealDTO), id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mealService.delete(id);
    }

}
