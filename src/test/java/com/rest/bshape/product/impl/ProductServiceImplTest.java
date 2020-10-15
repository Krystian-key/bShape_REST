package com.rest.bshape.product.impl;

import com.rest.bshape.bodytype.BodyTypeRepository;
import com.rest.bshape.bodytype.domain.BodyType;
import com.rest.bshape.bodytype.impl.BodyTypeServiceImpl;
import com.rest.bshape.product.ProductRepository;
import com.rest.bshape.product.ProductService;
import com.rest.bshape.product.domain.Product;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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
    void  shouldFindProductById() {
    }

    @Test
    void  shouldCreateProduct() {
    }

    @Test
    void  shouldUpdateProduct() {
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
        verify(productRepository,times(1)).deleteById(1L);
    }
}