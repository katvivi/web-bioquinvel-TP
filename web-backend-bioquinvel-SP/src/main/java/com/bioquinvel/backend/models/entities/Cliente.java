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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="clientes")
public class Cliente extends Persona  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_cliente")
	private Integer idcliente;
	
	@Column(name="emailCliente")
	private String emailCliente;
	
	@Column(name="ciudad")
	private String ciudad;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="codigoPostal")
	private String codigoPostal;
	
	@JoinColumn(name="id_pedido", referencedColumnName="id_pedido")
	@ManyToOne	
	private Pedido pedido;
	
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

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	@JsonIgnore
	public Pedido getPedido() {
		return pedido;
	}
	@JsonProperty(access = Access.WRITE_ONLY)
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
