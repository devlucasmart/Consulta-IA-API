package com.devlucasmart.consultaIA.controller;

import com.devlucasmart.consultaIA.dto.ConsultaIARequest;
import com.devlucasmart.consultaIA.service.ChatBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequiredArgsConstructor
public class ConsultaIAController {
    private final ChatBotService chatBotService;
    @PostMapping(value = "/consultaFraseIA")
    public String drawsFraseIA(@RequestBody ConsultaIARequest queryRequest) {
        String query = queryRequest.getQuery();
        return chatBotService.enviaQuery(query);
    }
}
