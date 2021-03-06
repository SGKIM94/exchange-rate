package com.woowahan.currency.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExchangeController {

    @GetMapping("/exchange")
    public ResponseEntity retrieveExchanges() {
        return ResponseEntity.ok().build();
    }
}
