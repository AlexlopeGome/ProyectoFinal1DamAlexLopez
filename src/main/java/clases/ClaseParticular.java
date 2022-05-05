package clases;

import java.time.LocalDate;
import java.util.ArrayList;

import enums.Asignatura;

public class ClaseParticular extends Gastos {

private Trabajador trabajador;
private Asignatura asignatura;
private ArrayList diasSemana;	
	
public ClaseParticular(String nombre, boolean importeFijo, float importe, LocalDate fecha, Trabajador trabajador,
			Asignatura asignatura, ArrayList diasSemana) {
		super(nombre, importeFijo, importe, fecha);
		this.trabajador = trabajador;
		this.asignatura = asignatura;
		this.diasSemana = diasSemana;
	}

public Trabajador getTrabajador() {
	return trabajador;
}
public void setTrabajador(Trabajador trabajador) {
	this.trabajador = trabajador;
}
public Asignatura getAsignatura() {
	return asignatura;
}
public void setAsignatura(Asignatura asignatura) {
	this.asignatura = asignatura;
}
public ArrayList getDiasSemana() {
	return diasSemana;
}
public void setDiasSemana(ArrayList diasSemana) {
	this.diasSemana = diasSemana;
}
@Override
public String toString() {
	return "ClaseParticular [trabajador=" + trabajador + ", asignatura=" + asignatura + ", diasSemana=" + diasSemana
			+ "]";
}

}
