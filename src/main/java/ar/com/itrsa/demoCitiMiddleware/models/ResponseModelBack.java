package ar.com.itrsa.demoCitiMiddleware.models;



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
}
