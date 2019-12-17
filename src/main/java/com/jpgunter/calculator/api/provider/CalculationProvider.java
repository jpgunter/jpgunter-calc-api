package com.jpgunter.calculator.api.provider;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CalculationProvider {

    /**
     * Add two numbers
     * @param num1String the first number
     * @param num2String the second number
     * @return the total
     * @throws IllegalArgumentException if either number cannot be parsed
     */
    public String add( String num1String, String num2String ) throws IllegalArgumentException {
        BigDecimal num1 = new BigDecimal( num1String );
        BigDecimal num2 = new BigDecimal( num2String );
        return num1.add( num2 ).toPlainString();
    }

    /**
     * Add two numbers
     * @param num1String the first number
     * @param num2String the second number
     * @return the total
     * @throws IllegalArgumentException if either number cannot be parsed
     */
    public String subtract( String num1String, String num2String ) throws IllegalArgumentException {
        BigDecimal num1 = new BigDecimal( num1String );
        BigDecimal num2 = new BigDecimal( num2String );
        return num1.subtract( num2 ).toPlainString();
    }
}
