package com.rest.bshape.product.converter;


import com.rest.bshape.product.domain.Product;
import com.rest.bshape.product.domain.ProductDTO;

import java.util.List;
import java.util.stream.Collectors;


public class ProductConverter {

    public static ProductDTO convertToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .weight(product.getWeight())
                .gigajoule(product.getGigajoule())
                .calories(product.getCalories())
                .alcohol(product.getAlcohol())
                .protein(product.getProtein())
                .fat(product.getFat())
                .carbohydrates(product.getCarbohydrates())
                .build();
    }

    public static Product convertFromDTO(ProductDTO productDTO) {
        return Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .weight(productDTO.getWeight())
                .gigajoule(productDTO.getGigajoule())
                .calories(productDTO.getCalories())
                .alcohol(productDTO.getAlcohol())
                .protein(productDTO.getProtein())
                .fat(productDTO.getFat())
                .carbohydrates(productDTO.getCarbohydrates())
                .build();
    }

    public static List<ProductDTO> mapToListDto(List<Product> productList) {
        return productList.stream()
                .map(ProductConverter::convertToDTO)
                .collect(Collectors.toList());
    }
}
