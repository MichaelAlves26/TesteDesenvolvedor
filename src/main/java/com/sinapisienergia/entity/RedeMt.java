package com.sinapisienergia.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TB_REDE_MT")
public class RedeMt implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_REDE_MT", nullable = false)
	private Long idRedeMt;
	
	@Column(name = "CODIGO", length = 5, nullable = false, unique = true)
	
	private String CodigoRede;
	
	@Column(name = "NOME", length = 100)
	
	private String nomeRede;
	
	@Column(name="TENSAO_NOMINAL", precision = 5, scale = 2)
	private BigDecimal tensaoNominal;
	
	
	
	

	public RedeMt() {
		super();
	}

	public RedeMt(Long idRedeMt, String codigoRede, String nomeRede, BigDecimal tensaoNominal) {
		super();
		this.idRedeMt = idRedeMt;
		this.CodigoRede = codigoRede;
		this.nomeRede = nomeRede;
		this.tensaoNominal = tensaoNominal;
	}

	public Long getIdRedeMt() {
		return idRedeMt;
	}

	public void setIdRedeMt(Long idRedeMt) {
		this.idRedeMt = idRedeMt;
	}

	public String getCodigoRede() {
		return CodigoRede;
	}

	public void setCodigoRede(String codigoRede) {
		CodigoRede = codigoRede;
	}

	public String getNomeRede() {
		return nomeRede;
	}

	public void setNomeRede(String nomeRede) {
		this.nomeRede = nomeRede;
	}

	public BigDecimal getTensaoNominal() {
		return tensaoNominal;
	}

	public void setTensaoNominal(BigDecimal tensaoNominal) {
		this.tensaoNominal = tensaoNominal;
	}

	

	
	
}
