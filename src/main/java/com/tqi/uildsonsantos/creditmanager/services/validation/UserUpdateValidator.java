package com.tqi.uildsonsantos.creditmanager.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.tqi.uildsonsantos.creditmanager.dtos.UserUpdateDTO;
import com.tqi.uildsonsantos.creditmanager.entities.User;
import com.tqi.uildsonsantos.creditmanager.repositories.UserRepository;
import com.tqi.uildsonsantos.creditmanager.resources.exceptions.FieldMessage;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private UserRepository repository;

	@Override
	public void initialize(UserUpdateValid ann) {
	}

	@Override
	public boolean isValid(UserUpdateDTO dto, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		var uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		long userId = Long.parseLong(uriVars.get("id"));

		List<FieldMessage> list = new ArrayList<>();

		User user = repository.findByEmail(dto.getEmail());
		if (user != null && userId != user.getId()) {
			list.add(new FieldMessage("email", "Email já existe"));
		}
		
		User isValidCPFOfuser = repository.findByCpf(dto.getCpf());
		if (isValidCPFOfuser != null && userId != user.getId()) {
			list.add(new FieldMessage("cpf", "CPF já existe"));
		}
		
		User isValidRGOfuser = repository.findByRg(dto.getRg());
		if (isValidRGOfuser != null && userId != user.getId()) {
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
