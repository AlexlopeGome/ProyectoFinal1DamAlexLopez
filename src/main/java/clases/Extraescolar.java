package clases;

import java.time.LocalDate;
import java.util.ArrayList;

import enums.Clases;
import enums.DiasSemana;
import enums.TipoActividadDesenpeniada;

public class Extraescolar extends Gastos{
	private Clases clase;
	private DiasSemana diasSemana;
	private String nombreProfesor;
	public Extraescolar(String nombre, boolean importeFijo, float importe, LocalDate fecha, int codigoMovimiento,
			Clases clase, DiasSemana diasSemana, String nombreProfesor) {
		super(nombre, importeFijo, importe, fecha, codigoMovimiento);
		this.clase = clase;
		this.diasSemana = diasSemana;
		this.nombreProfesor = nombreProfesor;
		
		
		
		
	}
	public Clases getClase() {
		return clase;
	}
	public void setClase(Clases clase) {
		this.clase = clase;
	}
	public DiasSemana getDiasSemana() {
		return diasSemana;
	}
	public void setDiasSemana(DiasSemana diasSemana) {
		this.diasSemana = diasSemana;
	}
	public String getNombreProfesor() {
		return nombreProfesor;
	}
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}
	@Override
	public String toString() {
		return "Extraescolar [clase=" + clase + ", diasSemana=" + diasSemana + ", nombreProfesor=" + nombreProfesor
				+ "]";
	}
	
	
	
	
	

	
	
}
