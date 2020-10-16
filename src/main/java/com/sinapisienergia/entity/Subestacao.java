package com.sinapisienergia.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



@Entity
@Table(name = "TB_SUBESTACAO")
public class Subestacao implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID_SUBESTACAO")
	private Long idSubestacao;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_SUBESTACAO", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<RedeMt> redeMt;
	
	@Column(length = 3, unique = true, nullable = false)
	private String codigo;
	
	@Column(name="NOME", length = 100)
	private String nome;
	
	@Column(name="LATITUDE", precision = 15, scale = 13, nullable = false)
	private BigDecimal latitude;
	
	@Column(name="LONGITUDE", precision = 15, scale = 13)
	private BigDecimal longitude;
	
	
		
	
	public Subestacao() {
		super();
	}

	public Subestacao(Long idSubestacao, String codigo, String nome, BigDecimal latitude, BigDecimal longitude,
			List<RedeMt> redeMt) {
		super();
		this.idSubestacao = idSubestacao;
		this.codigo = codigo;
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
		this.redeMt = redeMt;
	}

	public Long getIdSubestacao() {
		return idSubestacao;
	}

	public void setIdSubestacao(Long idSubestacao) {
		this.idSubestacao = idSubestacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public List<RedeMt> getRedeMt() {
		return redeMt;
	}

	public void setRedeMt(List<RedeMt> redeMt) {
		this.redeMt = redeMt;
	}

	
	
	

}
