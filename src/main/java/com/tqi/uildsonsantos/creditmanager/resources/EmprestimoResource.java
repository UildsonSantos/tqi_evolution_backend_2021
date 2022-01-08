package com.tqi.uildsonsantos.creditmanager.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tqi.uildsonsantos.creditmanager.dtos.EmprestimoDTO;
import com.tqi.uildsonsantos.creditmanager.dtos.EmprestimoDetailDTO;
import com.tqi.uildsonsantos.creditmanager.services.EmprestimoService;

@RestController
@RequestMapping(value = "/api/v1/emprestimos")
public class EmprestimoResource implements EmprestimoResourceDocs{

	@Autowired
	EmprestimoService emprestimoService;

	@PostMapping
	public ResponseEntity<EmprestimoDTO> insert(@Valid @RequestBody EmprestimoDTO dto) {

		EmprestimoDTO emprestimoDTO = emprestimoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emprestimoDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(emprestimoDTO);
	}

	@GetMapping(value = "/{id}/details")
	public ResponseEntity<EmprestimoDetailDTO> findByIdAndUserId(@PathVariable Long id) {
		EmprestimoDetailDTO emprestimo = emprestimoService.findByIdAndUserId(id);
		return ResponseEntity.ok().body(emprestimo);
	}
	
	@GetMapping
	public ResponseEntity<List<EmprestimoDTO>> findEmprestimosUser() {
		List<EmprestimoDTO> emprestimos = emprestimoService.findByUser();
		return ResponseEntity.ok().body(emprestimos);
	}
}
