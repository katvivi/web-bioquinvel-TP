package com.bioquinvel.backend.models.entities;

import java.io.Serializable;
import java.util.Calendar;
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
@Table(name="pedidos")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_pedido")
	private Integer idPedido;//Atributo que se mapea con la Primary Key
	
	@Column(name="fecha_Pedido")
	private Calendar fechaPedido;
	
	@Column(name="fecha_Entrega")
	private Calendar fechaEntrega;
	
	@Column(name="total_compra")
	private float total;
	
	@Column(name="aplica_descuento")
	private float descuento;
	
	@Column(name="recargo_envio")
	private float recargo;
	
	//mappedBy va el nombre del atributo de esta clase [pedido] en la clase asociada [LineaPedido]
	@OneToMany(mappedBy="pedido", fetch = FetchType.LAZY)	
	 
	private List<LineaPedido> lineaPedidos;
	
	public Pedido() {
		super();
	}
	
	public Pedido(int id) {
		super();
		this.idPedido = id;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Calendar getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Calendar fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Calendar getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Calendar fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public float getRecargo() {
		return recargo;
	}

	public void setRecargo(float recargo) {
		this.recargo = recargo;
	}

	public List<LineaPedido> getLineaPedidos() {
		return lineaPedidos;
	}

	public void setLineaPedidos(List<LineaPedido> lineaPedidos) {
		this.lineaPedidos = lineaPedidos;
	}

	
}
