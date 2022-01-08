package com.tqi.uildsonsantos.creditmanager.dtos;

import java.time.Instant;

import com.tqi.uildsonsantos.creditmanager.entities.Emprestimo;

public class EmprestimoDetailDTO extends EmprestimoDTO {
	private static final long serialVersionUID = 1L;

	private UserDetailDTO user;

	public EmprestimoDetailDTO() {
		super();
	}

	public EmprestimoDetailDTO(Long id, String qtdParcelas, Double valor, Instant dataPrimeiraParcela,
			UserDetailDTO user) {
		super(id, qtdParcelas, valor, dataPrimeiraParcela);

		this.user = user;
	}

	public EmprestimoDetailDTO(Emprestimo entity) {
		super.setId(entity.getId());
		super.setQtdParcelas(String.valueOf(entity.getQtdParcelas()));
		super.setValor(entity.getValor());
		super.setDataPrimeiraParcela(entity.getDataPrimeiraParcela());
		user = new UserDetailDTO(entity.getUser());
	}

	public UserDetailDTO getUser() {
		return user;
	}

	public void setUser(UserDetailDTO user) {
		this.user = user;
	}
}
