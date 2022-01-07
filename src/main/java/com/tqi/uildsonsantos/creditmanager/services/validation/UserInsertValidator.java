package com.tqi.uildsonsantos.creditmanager.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.tqi.uildsonsantos.creditmanager.dtos.UserInsertDTO;
import com.tqi.uildsonsantos.creditmanager.entities.User;
import com.tqi.uildsonsantos.creditmanager.repositories.UserRepository;
import com.tqi.uildsonsantos.creditmanager.resources.exceptions.FieldMessage;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public void initialize(UserInsertValid ann) {
	}

	@Override
	public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		User isValidEmailOfuser = repository.findByEmail(dto.getEmail());
		if (isValidEmailOfuser != null) {
			list.add(new FieldMessage("email", "Email já existe"));
		}
		
		User isValidCPFOfuser = repository.findByCpf(dto.getCpf());
		if (isValidCPFOfuser != null) {
			list.add(new FieldMessage("cpf", "CPF já existe"));
		}
		
		User isValidRGOfuser = repository.findByRg(dto.getRg());
		if (isValidRGOfuser != null) {
			list.add(new FieldMessage("RG", "RG já existe"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
