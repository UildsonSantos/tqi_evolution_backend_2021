package com.tqi.uildsonsantos.creditmanager.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tqi.uildsonsantos.creditmanager.dtos.EmprestimoDTO;
import com.tqi.uildsonsantos.creditmanager.dtos.EmprestimoDetailDTO;
import com.tqi.uildsonsantos.creditmanager.entities.Emprestimo;
import com.tqi.uildsonsantos.creditmanager.entities.User;
import com.tqi.uildsonsantos.creditmanager.repositories.EmprestimoRepository;
import com.tqi.uildsonsantos.creditmanager.services.exceptions.ResourceNotFoundException;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@Autowired
	private AuthService authService;

	@Transactional(readOnly = true)
	public List<EmprestimoDTO> findByUser() {

		User user = authService.authenticated();

		List<Emprestimo> emprestimos = emprestimoRepository.findByUser(user);
		return emprestimos.stream().map(emprestimo -> new EmprestimoDTO(emprestimo)).collect(Collectors.toList());
	}

	@Transactional
	public EmprestimoDTO insert(EmprestimoDTO dto) {
		User user = authService.authenticated();

		Emprestimo emprestimo = new Emprestimo();

		emprestimo.setQtdParcelas(dto.getQtdParcelas());
		emprestimo.setValor(dto.getValor());
		emprestimo.setUser(user);
		emprestimo.setDataPrimeiraParcela(dto.getDataPrimeiraParcela());

		emprestimo = emprestimoRepository.save(emprestimo);

		return new EmprestimoDTO(emprestimo);
	}

	@Transactional(readOnly = true)
	public EmprestimoDetailDTO findById(Long id) {
		Optional<Emprestimo> emprestimo = emprestimoRepository.findById(id);

		Emprestimo entity = emprestimo.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new EmprestimoDetailDTO(entity);
	}

	@Transactional(readOnly = true)
	public EmprestimoDetailDTO findByIdAndUserId(Long id) {

		Optional<Emprestimo> emprestimo = emprestimoRepository.findByIdAndUserId(id);

		Emprestimo entity = emprestimo.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new EmprestimoDetailDTO(entity);
	}
}
