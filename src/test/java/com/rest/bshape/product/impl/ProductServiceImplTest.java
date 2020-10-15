package com.rest.bshape.product.impl;

import com.rest.bshape.product.ProductRepository;
import com.rest.bshape.product.domain.Product;
import com.rest.bshape.product.domain.ProductID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void shouldFindAllProducts() {
        Product product = new Product();
        given(productRepository.findAll()).willReturn(Collections.singletonList(product));
        List<Product> result = productService.findAll();
        assertThat(result).hasSize(1).contains(product);
    }

    @Test
    void shouldReturnProductForFindById() {
        Product product = new Product();
        given(productRepository.findById(1L)).willReturn(Optional.of(product));

        Product result = productService.findById(1L);
        assertThat(result).isEqualTo(product);

    }

    @Test
    void shouldCreateProduct() {
        Product product = new Product();
        product.setId(1L);
        given(productRepository.save(any())).willReturn(product);

        ProductID result = productService.create(product);
        assertThat(result).isEqualTo(new ProductID(1L));
    }

    @Test
    void shouldUpdateProduct() {
        Product product = new Product();
        given(productRepository.save(any())).willReturn(product);
        given(productRepository.findById(1L)).willReturn(Optional.of(product));

        Product result = productService.update(product, 1L);
        assertThat(result).isEqualTo(product);
    }

    @Test
    void shouldDeleteProduct() {
        doNothing().when(productRepository).deleteById(any());
        productService.delete(1L);
        verify(productRepository, times(1)).deleteById(1L);
    }

    @Test
    void shouldThrowExceptionDuringUpdate() {

        given(productRepository.findById(1L)).willReturn(Optional.empty());
        Product product = Product.builder()
                .id(1L)
                .build();

        Long id = 1L;
        Product productParam = new Product();

        assertThatThrownBy(() -> productService.update(productParam, id))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("Product not found with id :1");
    }

    @Test
    void shouldFindEmptyProductList() {
        given(productRepository.findAll()).willReturn(Collections.emptyList());

        List<Product> result = productService.findAll();
        assertThat(result).isEmpty();
    }


    @Test
    void shouldThrowExceptionDuringDeleteById() {

        doThrow(EmptyResultDataAccessException.class).when(productRepository).deleteById(any());
        assertThatThrownBy(() -> productService.delete(any())).isInstanceOf(EmptyResultDataAccessException.class);


    }

}