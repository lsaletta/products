package com.inditex.products.controllers;


import com.inditex.products.model.Product;
import com.inditex.products.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/inditex")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping(path = "/products", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get available produtcs")
    public ResponseEntity<List<Product>> getAvailableProducts() {
        log.info(">>> Launch getAvailableProducts Operation");

        List<Product> products = productService.availableProducts();

        return CollectionUtils.isEmpty(products) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : ResponseEntity.ok(products);
    }


}
