package com.tqi.uildsonsantos.creditmanager.dtos;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.tqi.uildsonsantos.creditmanager.entities.Emprestimo;
import com.tqi.uildsonsantos.creditmanager.resources.validation.EmprestimoValid;

@EmprestimoValid
public class EmprestimoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@Pattern(regexp="\\d{1,2}", message = "O atributo 'qtdParcelas' deve ser número inteiro com um ou dois digitos")
	private String qtdParcelas;

	@NotNull(message = "Valor do emprestimo é obrigatório")
	@Digits(integer = 4, fraction = 2, message = "Apenas milhar e 2 casas após o ponto.")
	private double valor;

	@NotNull(message = "Data do primeiro pagamento é obrigatório")
	@Future(message = "A Primeira data do pagamento não pode ser anterior a data atual")
	private Instant dataPrimeiraParcela;

	public EmprestimoDTO() {
	}

	public EmprestimoDTO(Long id, String qtdParcelas, Double valor, Instant dataPrimeiraParcela) {
		this.id = id;
		this.qtdParcelas = qtdParcelas;
		this.valor = valor;
		this.dataPrimeiraParcela = dataPrimeiraParcela;
	}

	public EmprestimoDTO(Emprestimo entity) {
		id = entity.getId();
		qtdParcelas = String.valueOf(entity.getQtdParcelas());
		valor = entity.getValor();
		dataPrimeiraParcela = entity.getDataPrimeiraParcela();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQtdParcelas() {
		return Integer.parseInt(qtdParcelas);
	}

	public void setQtdParcelas(String qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Instant getDataPrimeiraParcela() {
		return dataPrimeiraParcela;
	}

	public void setDataPrimeiraParcela(Instant dataPrimeiraParcela) {
		this.dataPrimeiraParcela = dataPrimeiraParcela;
	}
}
