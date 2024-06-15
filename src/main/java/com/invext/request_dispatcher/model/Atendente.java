package com.invext.request_dispatcher.model;

import java.util.LinkedList;
import java.util.Queue;

public class Atendente {
    private String id;
    private Queue<Requisicao> requisicoes;

    public Atendente(String id) {
        this.id = id;
        this.requisicoes = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return requisicoes.size() < 3;
    }

    public void addRequisicao(Requisicao requisicao) {
        if (isAvailable()) {
            requisicoes.add(requisicao);
        }
    }

    public Requisicao terminoRequisicao() {
        return requisicoes.poll();
    }
}
