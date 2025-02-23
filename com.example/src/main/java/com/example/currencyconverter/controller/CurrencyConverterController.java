package com.example.currencyconverter.controller;

import com.example.currencyconverter.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CurrencyConverterController {

    @Autowired
    private CurrencyConversionService conversionService;

    // Endpoint to fetch exchange rates
    @GetMapping("/rates")
    public Map<String, Object> getRates(@RequestParam(defaultValue = "USD") String base) {
        return conversionService.getExchangeRates(base);
    }

    // Endpoint to convert currency (using POST)
    @PostMapping("/convert")
    public Map<String, Object> convertCurrency(@RequestBody Map<String, Object> request) {
        String from = (String) request.get("from");
        String to = (String) request.get("to");

        // Ensure the 'amount' is a Number and convert it to a double
        double amount = 0.0;
        if (request.get("amount") instanceof Number) {
            amount = ((Number) request.get("amount")).doubleValue();
        } else {
            // Handle the case where amount is not a number (optional)
            throw new IllegalArgumentException("Amount must be a number");
        }

        double convertedAmount = conversionService.convertCurrency(from, to, amount);

        return Map.of(
                "from", from,
                "to", to,
                "amount", amount,
                "convertedAmount", convertedAmount
        );
    }
}
