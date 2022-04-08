package ar.com.itrsa.demoCitiMiddleware.models;

import java.io.Serializable;
import java.util.Objects;

public class RequestModel implements Serializable {
	
	private Long tipoDocumento;
    private Integer numeroDocumento;
    
	public Long getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(Long tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numeroDocumento, tipoDocumento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestModel other = (RequestModel) obj;
		return Objects.equals(numeroDocumento, other.numeroDocumento)
				&& Objects.equals(tipoDocumento, other.tipoDocumento);
	}

}
