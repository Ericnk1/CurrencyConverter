package com.example.currencyconverter.model;

import lombok.Data;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

@Data
public class Converter {

    boolean success;

    Instant timestamp;

    String base;

    Date date;

    HashMap<String, Double> rates;
}
