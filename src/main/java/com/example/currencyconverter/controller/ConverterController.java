package com.example.currencyconverter.controller;

import com.example.currencyconverter.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/convert")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConverterController {

    @Autowired
    private ApiService apiService;

    /* @Autowired
    ConverterService converterService;*/

    @GetMapping()
    public Double convertCurrency(@RequestParam String from, @RequestParam String to, @RequestParam Double amount) throws IOException {
        return apiService.convertCurrency(from, to, amount);
    }
}
