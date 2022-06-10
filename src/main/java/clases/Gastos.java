package clases;

import java.time.LocalDate;

/**
 * 
 * @author AlexLopez
 *
 */
public class Gastos extends Movimiento {
/**
 * 
 * @param nombre nombre del nuevo movimiento 
 * @param importeFijo buleano q nos indica si es fijo o no
 * @param importe importe de movimiento
 * @param fecha fecha del movimiento que fue,que sera. o que es .
 * @param codigoMovimiento condigo para identificar el movimiento
 */
	public Gastos(String nombre, boolean importeFijo, float importe, LocalDate fecha, int codigoMovimiento) {
		super(nombre, importeFijo, importe, fecha, codigoMovimiento);
		// TODO Auto-generated constructor stub
	}

/**
 * clase vacia para poder monta diferentes costructes en otra clase
 */
	public Gastos() {

	}

}
