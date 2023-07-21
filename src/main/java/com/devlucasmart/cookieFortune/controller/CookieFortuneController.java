package com.devlucasmart.cookieFortune.controller;

import com.devlucasmart.cookieFortune.data.FraseSorte;
import com.devlucasmart.cookieFortune.exceptions.NumeroNaoInformadoException;
import com.devlucasmart.cookieFortune.service.ChatBotService;
import com.devlucasmart.cookieFortune.service.CookieFortuneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequiredArgsConstructor
public class CookieFortuneController {

    private final CookieFortuneService cookieFortuneService;

    private final ChatBotService chatBotService;

    @GetMapping(value = "/sorteiaFrase", produces = MediaType.APPLICATION_JSON_VALUE)
    public FraseSorte sorteiaFrase() {
        return cookieFortuneService.sorteiaFrase();
    }

    @GetMapping(value = "/sorteiaFraseIA")
    public String sorteiaFraseIA() throws IOException, ParseException, org.apache.hc.core5.http.ParseException {
        return chatBotService.enviaQuery("Me de uma frase de Biscoito da Sorte");
    }
    @GetMapping("/sorteiaNumero/{numero}")
    public String sorteiaNumero(@PathVariable String numero) {
        try {
            return cookieFortuneService.sorteiaNumero(numero);
        } catch (Exception e){
            throw new NumeroNaoInformadoException();
        }

    }
}
