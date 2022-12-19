package com.inditex.products.domain.repository;

import com.inditex.products.domain.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
}