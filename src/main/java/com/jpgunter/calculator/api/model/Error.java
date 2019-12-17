package com.jpgunter.calculator.api.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Error {
    private int code;
    private String message;
}
