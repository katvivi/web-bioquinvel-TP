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
@Table(name="clientes")
public class Cliente extends Persona  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_cliente")
	private Integer idcliente;
	
	@Column(name="email_Cliente")
	private String emailCliente;
	
	@Column(name="clave_cliente")
	private String claveCliente;

	@Column(name="ciudad")
	private String ciudad;
	
	@Column(name="direccion_Cliente")
	private String direccionCliente;
	
	@Column(name="codigo_Postal")
	private String codigoPostal;
	
	public Cliente() {
		super();
	}

	public Cliente(Integer id) {
		super();
		this.idcliente = id;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getClaveCliente() {
		return claveCliente;
	}

	public void setClaveCliente(String claveCliente) {
		this.claveCliente = claveCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}	
}
