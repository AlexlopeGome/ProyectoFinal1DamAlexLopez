package clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Inglesos extends Movimiento {
	
private ArrayList tipoIngresos;
	
	
public Inglesos(String nombre, boolean importeFijo, float importe, LocalDate fecha, ArrayList tipoIngresos) {
		super(nombre, importeFijo, importe, fecha);
		this.tipoIngresos = tipoIngresos;
	}



public ArrayList getTipoIngresos() {
	return tipoIngresos;
}

public void setTipoIngresos(ArrayList tipoIngresos) {
	this.tipoIngresos = tipoIngresos;
}

@Override
public String toString() {
	return "Inglesos [tipoIngresos=" + tipoIngresos + "]";
}
	
}
