package br.com.rodrigo.lamboktests.model;

import lombok.Data;

@Data
public class Pessoa {
	private String nome;
	private Integer idade;
	private boolean isAtivo;
}
