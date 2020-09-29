package com.rest.bshape.product;

import com.rest.bshape.product.domain.Product;
import com.rest.bshape.product.domain.ProductID;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

    ProductID create(Product product);

    Product update(Product product, Long id);

    void delete(Long id);
}
