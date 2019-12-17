package com.jpgunter.calculator.api.controller;

import java.math.BigDecimal;
import java.util.function.BiFunction;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpgunter.calculator.api.model.Error;
import com.jpgunter.calculator.api.model.Response;
import com.jpgunter.calculator.api.provider.CalculationProvider;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor(onConstructor_ = @Autowired)
public class AddController {

    private CalculationProvider calculationProvider;

    @RequestMapping("/add")
    public Response add(@RequestParam(value = "num1") String num1, @RequestParam(value = "num2") String num2, HttpServletResponse response ){
        return performCalculation( num1, num2, response, calculationProvider::add );
    }

    @RequestMapping("/subtract")
    public Response subtract(@RequestParam(value = "num1") String num1, @RequestParam(value = "num2") String num2, HttpServletResponse response ){
        return performCalculation( num1, num2, response, calculationProvider::subtract );
    }

    private Response performCalculation(String num1, String num2, HttpServletResponse response, BiFunction<String, String, String> calculator){
        try {
            String total = calculator.apply( num1, num2 );
            return Response.builder()
                    .total( total )
                    .build();
        } catch (IllegalArgumentException e){
            response.setStatus( HttpServletResponse.SC_BAD_REQUEST );
            return Response.builder()
                    .error( Error.builder()
                            .code( 400 )
                            .message( "Invalid arguments" )
                            .build())
                    .build();
        }
    }
}
