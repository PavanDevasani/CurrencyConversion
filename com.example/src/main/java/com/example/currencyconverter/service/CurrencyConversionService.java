package com.example.currencyconverter.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyConversionService {

    // Simulated exchange rates (base currency: USD)
    private final Map<String, Double> exchangeRates = new HashMap<>();

    public CurrencyConversionService() {
        // Example rates: 1 USD to other currencies
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.945);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 74.50);
        exchangeRates.put("JPY", 110.0);
    }

    // Method to get exchange rates for a given base currency
    public Map<String, Object> getExchangeRates(String base) {
        base = base.trim().toUpperCase();
        // Trim whitespace and normalize to uppercase

        if (!exchangeRates.containsKey(base)) {
            return Map.of(
                "success", false,
                "error", Map.of(
                    "code", 201,
                    "type", "invalid_base_currency",
                    "message", "The base currency '" + base + "' is not supported."
                )
            );
        }

        double baseRate = exchangeRates.get(base);
        Map<String, Double> rates = new HashMap<>();
        exchangeRates.forEach((currency, rate) -> rates.put(currency, rate / baseRate));

        return Map.of(
            "success", true,
            "base", base,
            "rates", rates
        );
    }

    // Method to convert currency
    public double convertCurrency(String from, String to, double amount) {
        from = from.trim().toUpperCase();
        to = to.trim().toUpperCase();

        if (!exchangeRates.containsKey(from) || !exchangeRates.containsKey(to)) {
            throw new IllegalArgumentException("Invalid currency code: " + from + " or " + to);
        }

        double fromRate = exchangeRates.get(from);
        double toRate = exchangeRates.get(to);
        
        // Ensure correct conversion formula
        return amount * (toRate / fromRate);
    }
}