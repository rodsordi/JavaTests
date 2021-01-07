package br.com.rodrigo.pattern.chain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
	private Long id;
	private String name;
	private int qtd;
	private boolean isError;
}
