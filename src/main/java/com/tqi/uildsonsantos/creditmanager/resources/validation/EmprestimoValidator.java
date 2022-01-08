package com.tqi.uildsonsantos.creditmanager.resources.validation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tqi.uildsonsantos.creditmanager.dtos.EmprestimoDTO;
import com.tqi.uildsonsantos.creditmanager.resources.exceptions.FieldMessage;

public class EmprestimoValidator implements ConstraintValidator<EmprestimoValid, EmprestimoDTO> {

	@Override
	public void initialize(EmprestimoValid ann) {
	}

	@Override
	public boolean isValid(EmprestimoDTO dto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		LocalDate ldNow = LocalDate.now().plusMonths(3);

		LocalDate isValidDate = LocalDateTime.ofInstant(dto.getDataPrimeiraParcela(), ZoneOffset.UTC).toLocalDate();

		if (dto.getValor() == null) {
			list.add(new FieldMessage("valor", "Preço deve ser um valor positivo"));
		}
		
		if (isValidDate.isAfter(ldNow)) {
			list.add(new FieldMessage("dataPrimeiraParcela",
					"Primeira parcela deve ser inferior a 3 meses em relação a data atual"));
		}

		if (dto.getQtdParcelas() > 60) {
			list.add(new FieldMessage("qtdParcelas", "As parcelas não pode ser maior que 60"));
		}
		
		if (dto.getQtdParcelas() < 1) {
			list.add(new FieldMessage("qtdParcelas", "A parcela minima deve ser maior ou igual a 1"));
		}
		
		if (dto.getValor() < 1) {
			list.add(new FieldMessage("valor", "Preço deve ser um valor positivo"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
