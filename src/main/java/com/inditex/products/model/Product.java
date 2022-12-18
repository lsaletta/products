package com.inditex.products.model;


import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Product {
    Integer id;
    Integer sequence;
}
