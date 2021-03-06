package com.woowahan.currency.controller;

import com.woowahan.currency.dto.CurrencyResponseDto;
import com.woowahan.currency.service.ExchangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping
    public ResponseEntity retrieveExchanges() {
        CurrencyResponseDto currency = exchangeService.retrieveExchanges();
        return ResponseEntity.ok(currency);
    }

    @PostMapping("/recipient/amount")
    public ResponseEntity calculateRecipientAmount() {
        return ResponseEntity.ok().build();
    }
}
