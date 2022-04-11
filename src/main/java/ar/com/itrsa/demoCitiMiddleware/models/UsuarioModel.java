package ar.com.itrsa.demoCitiMiddleware.models;

public class UsuarioModel {

	private Integer id;
	private String nombre;	
	private String email;	
	private Integer prioridad;	
	private TipoDocumentoModel tipoDocumento;	
	private Integer numeroDocumento;	
	private Long numeroCuentaBancaria;	
	private Integer monto;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}
	public TipoDocumentoModel getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumentoModel tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public Long getNumeroCuentaBancaria() {
		return numeroCuentaBancaria;
	}
	public void setNumeroCuentaBancaria(Long numeroCuentaBancaria) {
		this.numeroCuentaBancaria = numeroCuentaBancaria;
	}
	public Integer getMonto() {
		return monto;
	}
	public void setMonto(Integer monto) {
		this.monto = monto;
	}
	
}
