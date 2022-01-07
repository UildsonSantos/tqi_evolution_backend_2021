package com.tqi.uildsonsantos.creditmanager.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.tqi.uildsonsantos.creditmanager.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "Campo obrigatório")
	private String firstName;
	private String lastName;

	@Email(message = "Favor entrar um email válido")
	private String email;

	@Pattern(regexp = "(^(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{11})$)", message = "Favor entrar um CPF válido")
	private String cpf;

	@NotBlank(message = "Campo obrigatório")
	private String rg;
	private String endereco;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private Double renda;

	Set<RoleDTO> roles = new HashSet<>();

	public UserDTO() {
	}

	public UserDTO(Long id, String firstName, String lastName, String email, String cpf, String rg, String endereco,
			String numero, String bairro, String cidade, String estado, Double renda) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.renda = renda;
	}

	public UserDTO(User entity) {
		id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		email = entity.getEmail();
		cpf = entity.getCpf();
		rg = entity.getRg();
		endereco = entity.getEndereco();
		numero = entity.getNumero();
		bairro = entity.getBairro();
		cidade = entity.getCidade();
		estado = entity.getEstado();
		renda = entity.getRenda();

		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String end) {
		this.endereco = end;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}
}
