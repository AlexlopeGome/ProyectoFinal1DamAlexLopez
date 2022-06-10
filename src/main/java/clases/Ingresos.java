package clases;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 * @author AlexLopez
 *
 */
public class Ingresos extends Movimiento {

	/**
	 * 
	 * @param nombre
	 * @param importeFijo
	 * @param importe
	 * @param fecha
	 * @param codigoMovimiento
	 */
	public Ingresos(String nombre, boolean importeFijo, float importe, LocalDate fecha, int codigoMovimiento) {
		super(nombre, importeFijo, importe, fecha, codigoMovimiento);

	}

	/**
	 * 
	 */
	public Ingresos() {

	}

}
