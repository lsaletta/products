package com.inditex.products.domain.repository;

import com.inditex.products.domain.entity.SizeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SizeRepository extends CrudRepository<SizeEntity, Integer> {

    List<SizeEntity> findByProductId(Integer productId);

    Boolean existsBySpecialAndProductId(Boolean special, Integer productId);
}