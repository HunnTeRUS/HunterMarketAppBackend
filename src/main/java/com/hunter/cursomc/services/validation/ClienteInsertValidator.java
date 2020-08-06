package com.hunter.cursomc.services.validation;

import com.hunter.cursomc.domain.enums.TipoCliente;
import com.hunter.cursomc.dto.ClienteNewDTO;
import com.hunter.cursomc.repositories.ClienteRepository;
import com.hunter.cursomc.resources.exceptions.FieldMessage;
import com.hunter.cursomc.services.validation.util.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteInsert ann) {
    }

    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidSsn(objDto.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CPF Inválido"));
        }

        if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidTfn(objDto.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ Inválido"));
        }

        if(clienteRepository.findByEmail(objDto.getEmail()) != null){
            list.add(new FieldMessage("email", "Email ja existente"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getField()).addConstraintViolation();
        }

        return list.isEmpty();
    }
}