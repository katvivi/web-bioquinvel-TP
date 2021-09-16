package com.bioquinvel.backend.models.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name="tarjetas")
	private String tarjetas;
	
	@Column(name="calificacion")
	private String calificacion;
	
	@JoinColumn(name="id_producto", referencedColumnName= "id_producto")
	@ManyToOne(fetch = FetchType.LAZY)        
	private Producto producto;
				
	@JoinColumn(name = "id_detalle", referencedColumnName= "id_detalle")
	@ManyToOne(fetch = FetchType.LAZY)
	private Detalle detalle;
	
	@OneToMany(mappedBy="pedido", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Cliente> cliente;
	
	@Transient	
	private transient String nombre; 
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

	public String getFechaPedido() {
		if(this.fechaPedido == null) return "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		return sdf.format(fechaPedido.getTime());
	}

	public void setFechaPedido(Calendar fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	
	public String getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(String tarjetas) {
		this.tarjetas = tarjetas;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}
	
}
