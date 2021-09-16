package com.bioquinvel.backend.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="adicional")
public class Adicional implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_adicional")
	private Integer idAdicional;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="aroma")
	private String aroma;
	
	@Column(name="colorante")
	private String colorante;
	
	@Column(name="vitamina")
	private String vitamina;
	
	@OneToMany(mappedBy="adicional", fetch = FetchType.LAZY)	
	private List<Detalle> formulas;

	public Adicional() {
		super();
	}

	public Adicional(Integer idAdicional) {
		super();
		this.idAdicional = idAdicional;
	}
	
	public Integer getIdAdicional() {
		return idAdicional;
	}

	public void setIdAdicional(Integer idAdicional) {
		this.idAdicional = idAdicional;
	}

	public String getAroma() {
		return aroma;
	}

	public void setAroma(String aroma) {
		this.aroma = aroma;
	}

	public String getColorante() {
		return colorante;
	}

	public void setColorante(String colorante) {
		this.colorante = colorante;
	}

	public String getVitamina() {
		return vitamina;
	}

	public void setVitamina(String vitamina) {
		this.vitamina = vitamina;
	}
	
	public List<Detalle> getFormulas() {
		return formulas;
	}

	public void setFormulas(List<Detalle> formulas) {
		this.formulas = formulas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
		
}
