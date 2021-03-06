package com.woowahan.currency.controller;

import com.woowahan.currency.dto.CalculateRecipientRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ExchangeController {

    @GetMapping
    public String home(@ModelAttribute("exchange") CalculateRecipientRequestDto exchange) {
        return "index";
    }
}
