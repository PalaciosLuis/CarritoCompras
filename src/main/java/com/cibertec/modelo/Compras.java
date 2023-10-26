package com.cibertec.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "compras")
public class Compras {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int producto_id;
	private int cantidad;
	private double total;
	private Date fecha;

	public Compras() {
	}

	

	public Compras(int id, String nombre, int producto_id, int cantidad, double total, Date fecha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.producto_id = producto_id;
		this.cantidad = cantidad;
		this.total = total;
		this.fecha = fecha;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "compras [id=" + id + ", producto_id=" + producto_id + ", cantidad=" + cantidad + ", total=" + total
				+ ", fecha=" + fecha + "]";
	}

}
