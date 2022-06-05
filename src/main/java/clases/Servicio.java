package clases;

import java.time.LocalDate;
import java.util.ArrayList;

import enums.Clases;
import enums.DiasSemana;
import enums.TipoActividadDesenpeniada;

public class Servicio extends Gastos{
	private Clases clase;
	
	private String nombreTrabajador;
	public Servicio(String nombre, boolean importeFijo, float importe, LocalDate fecha, int codigoMovimiento,
			Clases clase, DiasSemana diasSemana, String nombreTrabajador) {
		super(nombre, importeFijo, importe, fecha, codigoMovimiento);
		this.clase = clase;
		this.nombreTrabajador = nombreTrabajador;
		
		
		
		
	}
	public Clases getClase() {
		return clase;
	}
	public void setClase(Clases clase) {
		this.clase = clase;
	}

	public String getNombreProfesor() {
		return nombreTrabajador;
	}
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreTrabajador= nombreProfesor;
	}
	@Override
	public String toString() {
		return "Extraescolar [clase=" + clase + ", nombreTrabajadorr=" + nombreTrabajador
				+ "]";
	}
	
	
	
	
	

	
	
}
