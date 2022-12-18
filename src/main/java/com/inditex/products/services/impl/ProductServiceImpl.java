package com.inditex.products.services.impl;

import com.inditex.products.model.Product;
import com.inditex.products.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> availableProducts() {
        return null;
    }
}
