package com.invext.request_dispatcher.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Time {
    private String name;
    private List<Atendente> atendentes;
    private Queue<Requisicao> queue;

    public Time(String name) {
        this.name = name;
        this.atendentes = new ArrayList<>();
        this.queue = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void adicionarAtendente(Atendente atendente) {
        atendentes.add(atendente);
    }

    public void adicionarRequisicao(Requisicao requisicao) {
        for (Atendente atendente : atendentes) {
            if (atendente.isAvailable()) {
                atendente.addRequisicao(requisicao);
                return;
            }
        }
        queue.add(requisicao);
    }

    public void processQueue() {
        while (!queue.isEmpty()) {
            for (Atendente atendente: atendentes) {
                atendente.addRequisicao(queue.poll());
                if (queue.isEmpty()) {
                    break;
                }
            }
        }
    }
}
