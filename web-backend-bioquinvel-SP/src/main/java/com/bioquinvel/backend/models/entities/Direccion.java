package com.bioquinvel.backend.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="direcciones")
public class Direccion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id_Direccion")
	private Integer idDireccion;
	
	@Column(name="ciudad")
	private String ciudad;
	
	@Column(name="direccion_Cliente")
	private String direccionCliente;
	
	@Column(name="codigo_Postal")
	private String codigoPostal;
	
	
	@JoinColumn(name="id_cliente", referencedColumnName= "id_cliente")
	@ManyToOne
	private Cliente cliente;

	public Direccion() {
		super();
	}

	public Direccion(Integer idDireccion) {
		super();
		this.idDireccion = idDireccion;
	}

	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
