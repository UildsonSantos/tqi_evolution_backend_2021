package com.tqi.uildsonsantos.creditmanager.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tqi.uildsonsantos.creditmanager.dtos.EmprestimoDTO;
import com.tqi.uildsonsantos.creditmanager.dtos.EmprestimoDetailDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Gerenciamento de emprestimos")
public interface EmprestimoResourceDocs {

	@ApiOperation(value = "Operação solicitar emprestimo")
	@ApiResponses( value = {
			@ApiResponse(code = 201, message = "Sucesso na criação do emprestimo"),
			@ApiResponse(code = 422, message = "Error de validação em algum atributo"),
			@ApiResponse(code = 401, message = "Usuário não autorizado")
	})
	ResponseEntity<EmprestimoDTO> insert( EmprestimoDTO dto);
	
	@ApiOperation(value = "Operação solicitar detalhes de um emprestimo do usuário logado")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "Sucesso na solicitação do emprestimo"),
			@ApiResponse(code = 404, message = "Error caso emprestimo não exista"),
			@ApiResponse(code = 401, message = "Usuário não autorizado")
	})
	public ResponseEntity<EmprestimoDetailDTO> findByIdAndUserId( Long id);
	
	@ApiOperation(value = "Operação solicitar todos os emprestimos do usuário logado")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "Sucesso na solicitação dos emprestimos"),
			@ApiResponse(code = 404, message = "Error caso os emprestimos não exista"),
			@ApiResponse(code = 401, message = "Usuário não autorizado")
	})
	public ResponseEntity<List<EmprestimoDTO>> findEmprestimosUser();
}

