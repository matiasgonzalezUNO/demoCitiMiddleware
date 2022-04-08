package ar.com.itrsa.demoCitiMiddleware.models;

public class TipoDocumentoModel {

    private Integer id;
	private String nombre;
	private String descripcion;
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public TipoDocumentoModel() {
		
	}
	public TipoDocumentoModel(String nombre, String descripcion) {	
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "TipoDocumentoModel [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
}
