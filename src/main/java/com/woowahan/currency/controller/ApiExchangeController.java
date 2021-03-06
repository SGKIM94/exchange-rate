package com.woowahan.currency.controller;

import com.woowahan.currency.dto.CalculateRecipientRequestDto;
import com.woowahan.currency.dto.CalculateRecipientResponseDto;
import com.woowahan.currency.dto.RetrieveExchangeResponseDto;
import com.woowahan.currency.service.ExchangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/exchange")
public class ApiExchangeController {

    private final ExchangeService exchangeService;

    public ApiExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping
    public ResponseEntity retrieveExchanges(@RequestParam String source, @RequestParam String destination) {
        RetrieveExchangeResponseDto currency = exchangeService.retrieveExchanges(source, destination);
        return ResponseEntity.ok(currency);
    }

    @PostMapping("/recipient/amount")
    public ResponseEntity calculateRecipientAmount(@Valid @RequestBody CalculateRecipientRequestDto request) {
        CalculateRecipientResponseDto recipientAmount = exchangeService.calculateRecipientAmount(request);
        return ResponseEntity.ok(recipientAmount);
    }
}
