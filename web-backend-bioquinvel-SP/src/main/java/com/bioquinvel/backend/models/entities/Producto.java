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
@Table(name="productos")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_producto")
	private Integer idProducto;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="precio")
	private float precio;
	
	@JoinColumn(name="id_lineaPedido", referencedColumnName= "id_lineaPedido")
	@ManyToOne
	private LineaPedido lineapedido;
	
	/*@OneToOne(mappedBy = "producto")
	private LineaPedido lineapedido;*/

	public Producto() {
		super();
	}

	public Producto(Integer idProducto) {
		super();
		this.idProducto = idProducto;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public LineaPedido getLineapedido() {
		return lineapedido;
	}

	public void setLineapedido(LineaPedido lineapedido) {
		this.lineapedido = lineapedido;
	}
}
