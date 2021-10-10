package com.example.currencyconverter.service;

import com.example.currencyconverter.model.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class ApiService {

    private static final String URL = "http://api.exchangeratesapi.io/v1/latest";
    private static final String API_KEY = "74e7fde1ffd4780877d0ca4f9a9121b3";
    public Double convertCurrency(String base, String to, Double amount) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("access_key", API_KEY)
                .queryParam("base", base)
                .queryParam("symbols", to);

        RestTemplate restTemplate = new RestTemplate();
        Converter response = restTemplate.getForObject(uriBuilder.toUriString(), Converter.class);

        assert response != null;
        return  response.getRates().get(to) * amount;
    }
}
