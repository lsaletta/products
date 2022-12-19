package com.inditex.products.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class InditexException extends RuntimeException {
    private static final long serialVersionUID = -4105726199013772984L;
    private String errorDescription;

    public InditexException(String errorDescription, Throwable throwable) {
        super(throwable);
        this.errorDescription = errorDescription;
    }
}
