package com.tqi.uildsonsantos.creditmanager.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.tqi.uildsonsantos.creditmanager.dtos.UserDTO;
import com.tqi.uildsonsantos.creditmanager.dtos.UserInsertDTO;
import com.tqi.uildsonsantos.creditmanager.dtos.UserUpdateDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("User management")
public interface UserResourceDocs {

	@ApiOperation(value = "Operação solicitar todos os usuários")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "Sucesso na solicitação"),
			@ApiResponse(code = 422, message = "Erro de validação em algum atributo"),
			@ApiResponse(code = 401, message = "Usuário não autorizado")
	})
	public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable);
	
	@ApiOperation(value = "Operação solicitar todos os usuários")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "Sucesso na solicitação"),
			@ApiResponse(code = 404, message = "Erro, usuario não encontrado"),
			@ApiResponse(code = 401, message = "Usuário não autorizado")
	})
	public ResponseEntity<UserDTO> findById(Long id);
	
	@ApiOperation(value = "Operação solicitar cadastramento de usuários")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "Sucesso na solicitação"),
			@ApiResponse(code = 422, message = "Erro de validação em algum atributo"),
			@ApiResponse(code = 404, message = "Erro, usuario não encontrado"),
			@ApiResponse(code = 403, message = "Erro, cliente não autorizado")
	})
	public ResponseEntity<UserDTO> insert(UserInsertDTO dto);
	
	@ApiOperation(value = "Operação solicitar cadastramento de usuários")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "Sucesso na solicitação"),
			@ApiResponse(code = 422, message = "Erro de validação em algum atributo"),
			@ApiResponse(code = 404, message = "Erro, usuario não encontrado"),
			@ApiResponse(code = 403, message = "Erro, cliente logado não autorizado")
	})
	ResponseEntity<UserDTO> update(Long id, UserUpdateDTO dto);
	
	@ApiOperation(value = "Operação solicitar cadastramento de usuários")
	@ApiResponses( value = {
			@ApiResponse(code = 204, message = "Sucesso na solicitação"),
			@ApiResponse(code = 404, message = "Erro, usuario não encontrado"),
			@ApiResponse(code = 403, message = "Erro, cliente logado não autorizado"),
			@ApiResponse(code = 400, message = "Erro, violação requisitos do banco de dados, caso usuário logado tenha emprestimos")
	})
	public ResponseEntity<Void> delete(Long id);
}
