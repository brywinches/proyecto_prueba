package entities;

import java.util.Date;

public class Producto {

	private String codArticulo;
	private String seccion;
	private String nomArticulo;
	private double precio;
	private Date fecha;
	private boolean importado;
	private String paisOrigen;
	

	public Producto() {
	}

	public Producto(String codArticulo, String seccion, String nomArticulo, double precio, Date fecha,
			boolean importado, String paisOrigen) {
		this.codArticulo = codArticulo;
		this.seccion = seccion;
		this.nomArticulo = nomArticulo;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.paisOrigen = paisOrigen;
		
	}

	public Producto(String seccion, String nomArticulo, double precio, Date fecha, boolean importado,
			String paisOrigen) {
		this.seccion = seccion;
		this.nomArticulo = nomArticulo;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.paisOrigen = paisOrigen;
		
	}

	public String getCodArticulo() {
		return codArticulo;
	}

	public void setCodArticulo(String codArticulo) {
		this.codArticulo = codArticulo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getNomArticulo() {
		return nomArticulo;
	}

	public void setNomArticulo(String nomArticulo) {
		this.nomArticulo = nomArticulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isImportado() {
		return importado;
	}

	public void setImportado(boolean importado) {
		this.importado = importado;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	@Override
	public String toString() {
		return "codArticulo=" + codArticulo + ", seccion=" + seccion + ", nomArticulo=" + nomArticulo + ", precio="
				+ precio + ", fecha=" + fecha + ", importado=" + importado + ", paisOrigen=" + paisOrigen;
	}

}
