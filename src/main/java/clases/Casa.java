package clases;

import java.util.ArrayList;

public class Casa {
	
private ArrayList Gastos;
private ArrayList Ingresos;	
	
public Casa(ArrayList gastos, ArrayList ingresos) {
		super();
		Gastos = gastos;
		Ingresos = ingresos;
	}

public ArrayList getGastos() {
	return Gastos;
}
public void setGastos(ArrayList gastos) {
	Gastos = gastos;
}
public ArrayList getIngresos() {
	return Ingresos;
}
public void setIngresos(ArrayList ingresos) {
	Ingresos = ingresos;
}
@Override
public String toString() {
	return "Casa [Gastos=" + Gastos + ", Ingresos=" + Ingresos + "]";
}
}
