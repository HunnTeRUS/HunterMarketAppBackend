package com.hunter.cursomc.services;

import com.hunter.cursomc.domain.Cidade;
import com.hunter.cursomc.domain.Cliente;
import com.hunter.cursomc.domain.Endereco;
import com.hunter.cursomc.domain.enums.Perfil;
import com.hunter.cursomc.domain.enums.TipoCliente;
import com.hunter.cursomc.dto.ClienteDTO;
import com.hunter.cursomc.dto.ClienteNewDTO;
import com.hunter.cursomc.repositories.ClienteRepository;
import com.hunter.cursomc.repositories.EnderecoRepository;
import com.hunter.cursomc.security.UserSS;
import com.hunter.cursomc.services.exceptions.AuthorizationException;
import com.hunter.cursomc.services.exceptions.DataIntegrityException;
import com.hunter.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private S3Services s3Services;

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private ImageService imageService;

    @Value("${img.prefix.client.profile}")
    private String prefixPicture;

    @Value("${image.profile.size}")
    private String imageprofilesize;

    public Cliente find(Integer id){
        UserSS userSS = UserServices.authenticated();

        if(userSS == null || !userSS.hasRole(Perfil.ADMIN) && !id.equals(userSS.getId())){
            throw new AuthorizationException("Acesso Negado!");
        }

        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    @Transactional
    public Cliente insert(Cliente obj) {
        obj.setId(null);
        obj = repo.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }

    public Cliente update(Cliente obj) {
        Cliente newObj = find(obj.getId());
            updateData(newObj, obj);
            return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir pois há entidades relacionadas");
        }
    }

    public List<Cliente> findAll(){
        return repo.findAll();
    }

    public Cliente findByEmail(String email){
        UserSS user = UserServices.authenticated();
        if(user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())){
            throw new AuthorizationException("Acesso Negado");
        }

        Cliente obj = repo.findByEmail(email);
        if(obj == null){
            throw new ObjectNotFoundException("Object not found! Id: " + user.getId() +
                    ", Type: " + Cliente.class.getName());
        }
        return obj;
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO dto){
        return new Cliente(dto.getId(), dto.getNome(), dto.getEmail(), null, null, null);
    }

    public Cliente fromDTO(ClienteNewDTO dto){
        Cliente cli = new Cliente(null, dto.getNome(), dto.getEmail(), dto.getCpfOuCnpj(), TipoCliente.toEnum(dto.getTipo()), pe.encode(dto.getSenha()));
        Cidade cid = new Cidade(dto.getCidadeId(), null,null);
        Endereco end = new Endereco(null, dto.getLogradouro(), dto.getNumero(), dto.getComplemento(), dto.getBairro(), dto.getCep(), cli, cid);
        cli.getEnderecos().add(end);
        cli.getTelefones().add(dto.getTelefone1());

        if(dto.getTelefone2()!=null)
            cli.getTelefones().add(dto.getTelefone2());

        if(dto.getTelefone3()!=null)
            cli.getTelefones().add(dto.getTelefone3());

        return cli;
    }

    private void updateData(Cliente newObj, Cliente obj){
        if(!obj.getEmail().equals(null))
            newObj.setEmail(obj.getEmail());

        if(!obj.getNome().equals(null))
            newObj.setNome(obj.getNome());
    }

    public URI uploadProfilePicture(MultipartFile file){
        UserSS userSS = UserServices.authenticated();

        if(userSS == null)
            throw new AuthorizationException("Acesso Negado");

        BufferedImage jpgImage = imageService.getJpgImageFromFile(file);
        jpgImage = imageService.cropSquare(jpgImage);
        jpgImage = imageService.resize(jpgImage, Integer.valueOf(imageprofilesize));

        String nome = prefixPicture + userSS.getId() + ".jpg";

        return s3Services.uploadFile(imageService.getInputStream(jpgImage, "jpg"), nome, "image");
    }
}
