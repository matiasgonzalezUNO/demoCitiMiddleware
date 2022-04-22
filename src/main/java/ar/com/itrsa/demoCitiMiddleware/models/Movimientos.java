package ar.com.itrsa.demoCitiMiddleware.models;

import java.util.Date;

public class Movimientos {

    private String utilDate;

    private String concepto;

    private String importe;


	public String getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(String utilDate) {
		this.utilDate = utilDate;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(Integer importe) {
		this.importe = String.valueOf(importe);
	}


	public Movimientos() {
		
	}
	
	public Movimientos(String utilDate, String concepto, Integer importe) {
		this.utilDate = utilDate;
		this.concepto = concepto;
		this.importe = String.valueOf(importe);
	}
    
	
    
}
