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

    private final String message = "Product not found with id :1";

    private final Long id = 1L;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Test
    void shouldThrowExceptionDuringUpdate() {

        given(productRepository.findById(id)).willReturn(Optional.empty());
        Product product = Product.builder()
                .id(id)
                .build();

        Product productParam = new Product();

        assertThatThrownBy(() -> productServiceImpl.update(productParam, id))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage(message);
    }

    @Test
    void shouldUpdateProduct() {
        Product product = new Product();
        given(productRepository.save(any())).willReturn(product);
        given(productRepository.findById(id)).willReturn(Optional.of(product));

        Product result = productServiceImpl.update(product, id);
        assertThat(result).isEqualTo(product);
    }

    @Test
    void shouldReturnValueForFindById() {
        Product product = new Product();
        given(productRepository.findById(id)).willReturn(Optional.of(product));

        Product result = productServiceImpl.findById(id);
        assertThat(result).isEqualTo(product);
    }

    @Test
    void shouldFindAllProducts() {
        Product product = new Product();
        given(productRepository.findAll()).willReturn(Collections.singletonList(product));
        List<Product> result = productServiceImpl.findAll();
        assertThat(result).hasSize(1).contains(product);
    }

    @Test
    void shouldFindEmptyProductList() {
        given(productRepository.findAll()).willReturn(Collections.emptyList());

        List<Product> result = productServiceImpl.findAll();
        assertThat(result).isEmpty();
    }


    @Test
    void shouldCreateProduct() {
        Product product = new Product();
        product.setId(id);
        given(productRepository.save(any())).willReturn(product);

        ProductID result = productServiceImpl.create(product);
        assertThat(result).isEqualTo(new ProductID(id));
    }

    @Test
    void shouldDeleteProduct() {
        doNothing().when(productRepository).deleteById(any());
        productServiceImpl.delete(id);
        verify(productRepository, times(1)).deleteById(id);
    }

    @Test
    void shouldThrowExceptionDuringDeleteById() {

        doThrow(EmptyResultDataAccessException.class).when(productRepository).deleteById(any());
        assertThatThrownBy(() -> productServiceImpl.delete(any())).isInstanceOf(EmptyResultDataAccessException.class);
    }
}
