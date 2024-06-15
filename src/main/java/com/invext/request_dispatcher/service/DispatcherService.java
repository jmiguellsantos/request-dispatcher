package com.invext.request_dispatcher.service;

import com.invext.request_dispatcher.model.Atendente;
import com.invext.request_dispatcher.model.Requisicao;
import com.invext.request_dispatcher.model.Time;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DispatcherService {
    private Map<String, Time> times;

    public DispatcherService() {
        times = new HashMap<>();
        times.put("Cartões", new Time("Cartões"));
        times.put("Empréstimos", new Time("Empréstimos"));
        times.put("Outros Assuntos", new Time("Outros Assuntos"));
    }

    public void adicioneAtendentesAoTime(String timeNome, Atendente atendente) {
        Time time = times.get(timeNome);
        if (time != null) {
            time.adicionarAtendente(atendente);
        }
    }

    public void dispatchRequisicao(Requisicao requisicao) {
        Time time;
        switch (requisicao.getType()) {
            case "Problemas com cartão":
                time = times.get("Cartões");
                break;
            case "Contratação de empréstimo":
                time = times.get("Empréstimos");
                break;
            default:
                time = times.get("Outros Assuntos");
                break;
        }
        if (time != null) {
            time.adicionarRequisicao(requisicao);
        }
    }

    public void processAllQueues() {
        for (Time time : times.values()) {
            time.processQueue();
        }
    }
}

