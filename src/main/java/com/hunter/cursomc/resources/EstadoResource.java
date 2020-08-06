package com.hunter.cursomc.resources;

import com.hunter.cursomc.domain.Cidade;
import com.hunter.cursomc.domain.Estado;
import com.hunter.cursomc.dto.CidadeDTO;
import com.hunter.cursomc.dto.EstadoDTO;
import com.hunter.cursomc.services.CidadeService;
import com.hunter.cursomc.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value= "/estados")
public class EstadoResource {

    @Autowired
    EstadoService estadoService;

    @Autowired
    CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> findAll(){
        List<Estado> listEstados = estadoService.findAllStates();
        List<EstadoDTO> listEstadosDTO = listEstados.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listEstadosDTO);
    }

    @GetMapping(value = "/{estados_id}/cidades")
    public ResponseEntity<List<CidadeDTO>> findAllCity(@PathVariable("estados_id") Integer estadoId){
        List<Cidade> cidades = cidadeService.findAll(estadoId);
        List<CidadeDTO> cidadesDTO = cidades.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(cidadesDTO);
    }

}
