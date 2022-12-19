package com.inditex.products.domain.repository;

import com.inditex.products.domain.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<StockEntity, Integer> {
}