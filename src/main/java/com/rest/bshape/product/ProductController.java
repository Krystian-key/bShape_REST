package com.rest.bshape.product;


import com.rest.bshape.product.domain.ProductDTO;
import com.rest.bshape.product.domain.ProductID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.rest.bshape.product.converter.ProductConverter.*;


@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> findAll() {

        return mapToListDto(productService.findAll());
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return convertToDTO(productService.findById(id));

    }

    @PostMapping
    public ProductID create(@RequestBody @Valid ProductDTO productDTO) {
        return productService.create(convertFromDTO(productDTO));
    }


    @PutMapping("/{id}")
    public ProductDTO update(@RequestBody ProductDTO productDTO, @PathVariable Long id) {
        return convertToDTO(productService.update(convertFromDTO(productDTO), id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
