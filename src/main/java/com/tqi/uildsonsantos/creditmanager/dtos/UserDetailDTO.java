package com.tqi.uildsonsantos.creditmanager.dtos;

import java.io.Serializable;

import com.tqi.uildsonsantos.creditmanager.entities.User;

public class UserDetailDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String email;

	private Double renda;

	public UserDetailDTO() {
	}

	public UserDetailDTO(Long id, String email, Double renda) {
		
		this.email = email;
		this.renda = renda;
	}

	public UserDetailDTO(User entity) {
		email = entity.getEmail();
		renda = entity.getRenda();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}
}
