package com.hunter.cursomc.domain.enums;

public enum Perfil {
    CLIENTE(1, "ROLE_CLIENTE"),
    ADMIN(2, "ROLE_ADMIN");

    private int cod;

    private String descricao;

    Perfil(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEnum(Integer cod) {
        if (cod == null) return null;

        for (Perfil x : Perfil.values()) {
            if(cod.equals(x.getCod())) return x;
        }
        new IllegalAccessException("Id invalido: " + cod);
        return null;
    }
}
