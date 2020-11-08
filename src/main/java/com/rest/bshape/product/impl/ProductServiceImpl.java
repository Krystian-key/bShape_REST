package com.rest.bshape.product.impl;

import com.rest.bshape.product.ProductRepository;
import com.rest.bshape.product.ProductService;
import com.rest.bshape.product.domain.Product;
import com.rest.bshape.product.domain.ProductID;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();

    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id :" + id));
    }

    @Override
    public ProductID create(Product product) {
        product = productRepository.save(product);
        return new ProductID(product.getId());
    }

    @Override
    public Product update(Product product, Long id) {

        return productRepository.save(findById(id)
                .toBuilder()
                .name(product.getName())
                .weight(product.getWeight())
                .gigajoule(product.getGigajoule())
                .calories(product.getCalories())
                .alcohol(product.getAlcohol())
                .protein(product.getProtein())
                .fat(product.getFat())
                .carbohydrates(product.getCarbohydrates())
                .build());
    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }
}
