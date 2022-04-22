package ar.com.itrsa.demoCitiMiddleware.models;

import java.util.List;

public class ResponceModelOfXml {

	private String nombre;
    
	private String numeroDeCuenta;
	
	private List<Movimientos> movimientos;

	public ResponceModelOfXml() {
		
	}
			
	public ResponceModelOfXml(String nombre, String numeroDeCuenta, List<Movimientos> movimientos) {
		super();
		this.nombre = nombre;
		this.numeroDeCuenta = numeroDeCuenta;
		this.movimientos = movimientos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroDeCuenta() {
		return numeroDeCuenta;
	}

	public void setNumeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}

	public List<Movimientos> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimientos> movimientos) {
		this.movimientos = movimientos;
	}
	
}
