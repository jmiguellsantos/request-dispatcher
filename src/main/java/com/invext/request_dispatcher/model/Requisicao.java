package com.invext.request_dispatcher.model;

public class Requisicao {

    private String id;
    private String type;

    public Requisicao(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
