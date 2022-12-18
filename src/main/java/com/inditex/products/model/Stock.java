package com.inditex.products.model;


import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Stock {
    Integer sizeId;
    Long quantity;
}
