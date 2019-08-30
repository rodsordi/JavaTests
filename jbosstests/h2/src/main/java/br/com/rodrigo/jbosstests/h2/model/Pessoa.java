package br.com.rodrigo.jbosstests.h2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "PESSOA")
public class Pessoa {
	@Id
	@GeneratedValue
	@Column(name = "SIST_ID_SISTEMA")
	private Long id;

	@Column(name = "SIST_CD_SISTEMA")
	private String codigo;
	
	@Column(name = "SIST_IN_STATUS")
	private Integer status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SIST_DT_CADASTRO")
	private Date dataCadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
}
