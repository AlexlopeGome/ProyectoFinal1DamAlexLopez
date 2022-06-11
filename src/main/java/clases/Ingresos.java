package clases;

import java.time.LocalDate;

import exepciones.NombreInvalidoExceptions;

/**
 * 
 * @author AlexLopez
 *
 */
public class Ingresos extends Movimiento {

	/**
	 * Contructor que nos alluda a contruir un novo ingreso
	 * 
	 * @param nombre           del nuevo ingleso
	 * @param importeFijo      nos indica con un booleano si es fijo o no
	 * @param importe          importe del nuevo movimiento
	 * @param fecha            fecha del movimiento que sera q fue o es
	 * @param codigoMovimiento codo del nuevo movimiento
	 * @throws NombreInvalidoExceptions nos salta la exepcion si el nobre no es
	 *                                  valido
	 */
	public Ingresos(String nombre, boolean importeFijo, float importe, LocalDate fecha, int codigoMovimiento)
			throws NombreInvalidoExceptions {
		super(nombre, importeFijo, importe, fecha, codigoMovimiento);

	}

	/**
	 * Contructor que nos alluda a contruir un novo ingreso
	 */
	public Ingresos() {

	}

}
