package com.bioquinvel.backend.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="lineaPedidos")
public class LineaPedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_lineaPedido")
	private Integer idLineaPedido;
	
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="stock")
	private int stock;
	
	@JoinColumn(name="id_pedido", referencedColumnName= "id_pedido")
	@ManyToOne
	@JsonIgnore 
	private Pedido pedido;//Representa la relacion
	
	/*@JoinColumn(name = "id_producto", nullable = false)
	@OneToOne(fetch = FetchType.LAZY)  
	private Producto producto;*/
	
	@OneToMany(mappedBy="lineapedido", fetch = FetchType.LAZY)	
	private List<Producto> productos;
	
	
	public LineaPedido() {
		super();
	}
	public LineaPedido(Integer idLineaPedido) {
		super();
		this.idLineaPedido = idLineaPedido;
	}
	public Integer getIdLineaPedido() {
		return idLineaPedido;
	}
	public void setIdLineaPedido(Integer idLineaPedido) {
		this.idLineaPedido = idLineaPedido;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public List<Producto> getProductos() {
		if (productos == null) 
			productos=new ArrayList<Producto>();
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
		
}
