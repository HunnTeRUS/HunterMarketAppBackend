package com.hunter.cursomc.services;

import com.hunter.cursomc.domain.Categoria;
import com.hunter.cursomc.dto.CategoriaDTO;
import com.hunter.cursomc.repositories.CategoriaRepository;
import com.hunter.cursomc.services.exceptions.DataIntegrityException;
import com.hunter.cursomc.services.exceptions.MethodArgumentNotValidException;
import com.hunter.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        try {
            return repo.save(obj);
        } catch (MethodArgumentNotValidException e) {
            throw new MethodArgumentNotValidException("Não é possivel excluir uma categoria que possui produtos");
        }
    }

    public Categoria update(Categoria obj) {
        find(obj.getId());
        try {
            return repo.save(obj);
        } catch (MethodArgumentNotValidException e) {
            throw new MethodArgumentNotValidException("Não é possivel excluir uma categoria que possui produtos");
        }
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
        }
    }

    public List<Categoria> findAll(){
        return repo.findAll();
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Categoria fromDTO(CategoriaDTO dto){
        return new Categoria(dto.getId(), dto.getNome());
    }
}
