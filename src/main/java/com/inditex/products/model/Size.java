package com.inditex.products.model;


import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Size {
    Integer id;
    Integer productId;
    Boolean backSoon;
    Boolean special;
}
