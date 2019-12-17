package com.jpgunter.calculator.api.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Response {
    private String total;
    private Error error;
}
