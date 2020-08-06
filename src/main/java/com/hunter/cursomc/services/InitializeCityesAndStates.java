package com.hunter.cursomc.services;

import com.hunter.cursomc.domain.Cidade;
import com.hunter.cursomc.domain.Estado;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitializeCityesAndStates {

    List<Cidade> cidadesList;
    RestTemplate restTemplate = new RestTemplate();

    public List<Cidade> getCidadesSP(Estado estado) {
            restTemplate = new RestTemplate();
            cidadesList = new ArrayList<>();
            List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/sp", List.class);

            for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
                cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
            }

            return cidadesList;
    }

    public List<Cidade> getCidadesRO(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/ro", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesAC(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/ac", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesAM(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/am", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesRR(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/rr", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesPA(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/pa", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesAP(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/ap", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesTO(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/to", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesMA(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/ma", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesPI(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/pi", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesCE(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/ce", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesRN(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/rn", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesPB(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/pb", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesPE(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/pe", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesAL(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/al", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesBA(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/ba", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesSE(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/se", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesMG(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/mg", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }
    public List<Cidade> getCidadesES(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/es", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesRJ(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/rj", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesPR(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/pr", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesSC(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/sc", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesRS(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/rs", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesMS(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/ms", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesMT(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/mt", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesGO(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/go", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }

    public List<Cidade> getCidadesDF(Estado estado) {
        restTemplate = new RestTemplate();
        cidadesList = new ArrayList<>();

        List<String> cidadesEstadosDTO = restTemplate.getForObject("http://educacao.dadosabertosbr.com/api/cidades/df", List.class);

        for(int i = 0; i<cidadesEstadosDTO.size(); i++) {
            cidadesList.add(new Cidade(null, cidadesEstadosDTO.get(i).substring(8), estado));
        }

        return cidadesList;
    }



}
