package com.hunter.cursomc.services;

import com.hunter.cursomc.domain.Categoria;
import com.hunter.cursomc.domain.Produto;
import com.hunter.cursomc.repositories.CategoriaRepository;
import com.hunter.cursomc.repositories.ProdutoRepository;
import com.hunter.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    @Autowired
    private CategoriaRepository repoCategorias;

    public Produto find(Integer id){
        Optional<Produto> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
    }

    public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = repoCategorias.findAllById(ids);

        return repo.search(nome, categorias, pageRequest);
    }


}
