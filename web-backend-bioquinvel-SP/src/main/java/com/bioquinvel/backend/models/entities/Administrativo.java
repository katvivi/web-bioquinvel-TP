package com.bioquinvel.backend.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administrativos")
public class Administrativo extends Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_administrativo")
	private Integer idAdministrativo;
	
	@Column(name="email_admin")
	private String emailAdmin;
	
	@Column(name="clave_administrativo")
	private String claveAdministrativo;
	
	public Administrativo() {
		super();
	}

	public Administrativo(Integer id) {
		super();
		this.idAdministrativo = id;
	}

	public Integer getIdAdministrativo() {
		return idAdministrativo;
	}

	public void setIdAdministrativo(Integer idAdministrativo) {
		this.idAdministrativo = idAdministrativo;
	}
	
	public String getEmailAdmin() {
		return emailAdmin;
	}

	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}

	public String getClaveAdministrativo() {
		return claveAdministrativo;
	}

	public void setClaveAdministrativo(String claveAdministrativo) {
		this.claveAdministrativo = claveAdministrativo;
	}
	
	
}
