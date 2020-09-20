package com.rest.bshape.target;


import com.rest.bshape.target.domain.TargetDTO;
import com.rest.bshape.target.domain.TargetID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.rest.bshape.target.converter.TargetConverter.*;


@RestController
@RequestMapping("/api/target")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
class TargetController {

    private final TargetService targetService;


    @GetMapping
    public List<TargetDTO> findAll() {
        return mapToListDto(targetService.findAll());
    }


    @GetMapping("/{id}")
    public TargetDTO findById(@PathVariable Long id) {
        return convertToDTO(targetService.findById(id));

    }

    @PostMapping
    public TargetID create(@RequestBody @Valid TargetDTO targetDTO) {
        return targetService.create(convertFromDTO(targetDTO));
    }


    @PutMapping("/{id}")
    public TargetDTO update(@RequestBody TargetDTO targetDTO, @PathVariable Long id) {
        return convertToDTO(targetService.update(convertFromDTO(targetDTO), id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        targetService.delete(id);
    }

}
