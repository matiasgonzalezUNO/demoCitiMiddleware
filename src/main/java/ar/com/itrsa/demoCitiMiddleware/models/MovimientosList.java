package ar.com.itrsa.demoCitiMiddleware.models;

import java.util.ArrayList;
import java.util.List;

public class MovimientosList {

	private List<Movimientos> movimientos;
	
	public MovimientosList() {
		movimientos = new ArrayList<>();
    }

	public List<Movimientos> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimientos> movimientos) {
		this.movimientos = movimientos;
	}

	@Override
	public String toString() {
		return "MovimientosList [movimientos=" + movimientos + ", getMovimientos()=" + getMovimientos()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
