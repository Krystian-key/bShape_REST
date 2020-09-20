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
                .orElseThrow(() -> new EntityNotFoundException("BodyType not found with id :" + id));
    }

    @Override
    public ProductID create(Product product) {
        product = productRepository.save(product);
        return new ProductID(product.getId());
    }

    @Override
    public Product update(Product product, Long id) {

        Product productById = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BodyType not found with id :" + id));

        productById.setName(product.getName());
        productById.setWeight(product.getWeight());
        productById.setGigajoule(product.getGigajoule());
        productById.setCalories(product.getCalories());
        productById.setAlcohol(product.getAlcohol());
        productById.setProtein(product.getProtein());
        productById.setFat(product.getFat());
        productById.setCarbohydrates(product.getCarbohydrates());
        return productRepository.save(productById);
    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }
}
