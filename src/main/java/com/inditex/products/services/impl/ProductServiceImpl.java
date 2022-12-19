package com.inditex.products.services.impl;

import com.inditex.products.domain.repository.ProductRepository;
import com.inditex.products.domain.repository.SizeRepository;
import com.inditex.products.domain.repository.StockRepository;
import com.inditex.products.model.Product;
import com.inditex.products.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final SizeRepository sizeRepository;
    private final StockRepository stockRepository;

    @Override
    public List<Product> availableProducts() {
        return null;
    }

}
