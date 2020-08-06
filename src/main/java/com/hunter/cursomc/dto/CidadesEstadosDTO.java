package com.hunter.cursomc.dto;

import java.util.List;

public class CidadesEstadosDTO {

    public CidadesEstadosDTO() {
    }

    public List<String> citiesByStates;

    public List<String> getCidade() {
        return citiesByStates;
    }

    public void setCidade(List<String> cidade) {
        this.citiesByStates = cidade;
    }
}
