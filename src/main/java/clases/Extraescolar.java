package clases;

import java.time.LocalDate;
import java.util.ArrayList;

import enums.Asignatura;

public class Extraescolar extends Gastos{

	private ArrayList profesoresExtraescolares;
	private Asignatura asignatura;
	private ArrayList diasSemana;	
	
public Extraescolar(String nombre, boolean importeFijo, float importe, LocalDate fecha,
			ArrayList profesoresExtraescolares, Asignatura asignatura, ArrayList diasSemana) {
		super(nombre, importeFijo, importe, fecha);
		this.profesoresExtraescolares = profesoresExtraescolares;
		this.asignatura = asignatura;
		this.diasSemana = diasSemana;
	}

public ArrayList getProfesoresExtraescolares() {
	return profesoresExtraescolares;
}
public void setProfesoresExtraescolares(ArrayList profesoresExtraescolares) {
	this.profesoresExtraescolares = profesoresExtraescolares;
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
	return "Extraescolar [profesoresExtraescolares=" + profesoresExtraescolares + ", asignatura=" + asignatura
			+ ", diasSemana=" + diasSemana + "]";
}
}
