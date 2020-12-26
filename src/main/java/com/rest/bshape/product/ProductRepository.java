package com.rest.bshape.product;

import com.rest.bshape.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;



public interface ProductRepository extends JpaRepository<Product, Long> {
}
