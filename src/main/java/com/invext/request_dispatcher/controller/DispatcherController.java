package com.invext.request_dispatcher.controller;

import com.invext.request_dispatcher.model.Atendente;
import com.invext.request_dispatcher.model.Requisicao;
import com.invext.request_dispatcher.service.DispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DispatcherController {

    @Autowired
    private DispatcherService dispatcherService;

    @PostMapping("/requisicao")
    public void adicionarRequisicao(@RequestParam String id, @RequestParam String type) {
        Requisicao requisicao = new Requisicao(id, type);
        dispatcherService.dispatchRequisicao(requisicao);
    }

    @PostMapping("/atendente")
    public void adicionarAtendente(@RequestParam String time, @RequestParam String atendenteId) {
        Atendente atendente = new Atendente(atendenteId);
        dispatcherService.adicioneAtendentesAoTime(time, atendente);
    }

    @PostMapping("/process")
    public void processQueues() {
        dispatcherService.processAllQueues();
    }
}
