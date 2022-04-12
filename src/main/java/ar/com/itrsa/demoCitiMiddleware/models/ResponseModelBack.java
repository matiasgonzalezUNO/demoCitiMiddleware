package ar.com.itrsa.demoCitiMiddleware.models;

import java.util.Objects;

public class ResponseModelBack {

	private int code;
    private boolean status;
    private String descripcion;
    private UsuarioModel Usuario;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UsuarioModel getUsuarioBack() {
        return Usuario;
    }

    public void setUsuarioBack(UsuarioModel saldoActual) {
        this.Usuario = saldoActual;
    }

	@Override
	public int hashCode() {
		return Objects.hash(Usuario, code, descripcion, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseModelBack other = (ResponseModelBack) obj;
		return Objects.equals(Usuario, other.Usuario) && code == other.code
				&& Objects.equals(descripcion, other.descripcion) && status == other.status;
	}
    
    
}
