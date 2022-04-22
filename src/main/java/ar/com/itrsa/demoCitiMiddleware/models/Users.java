package ar.com.itrsa.demoCitiMiddleware.models;

public class Users {
	
	private Integer id;
	    
	private String nombre;
	    
	private String numeroDeCuenta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void setNumeroDeCuenta(Integer numeroDeCuenta) {
		this.numeroDeCuenta = String.valueOf(numeroDeCuenta);
	}

	   
}
