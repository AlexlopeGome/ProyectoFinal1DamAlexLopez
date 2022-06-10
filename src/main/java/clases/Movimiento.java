package clases;

import java.time.LocalDate;

import exepciones.NombreInvalidoExceptions;

/**
 * 
 * @author AlexLopez
 *
 */
public class Movimiento extends EntidadConNombre {

	protected boolean importeFijo;
	protected float importe;
	protected LocalDate fecha;
	protected int codigoMovimiento;

	/**
	 * 
	 * @param nombre del nuevo movimiento
	 * @param importeFijo no s indica con un booleano si el importe es fijo no
	 * @param importe es el importe del nuebo movimiento
	 * @param fecha fecha del movimiento que  sera es o fue.
	 * @param codigoMovimiento condigo del nuevo movimiento 
	 * @throws NombreInvalidoExceptions no indica si ahy algun problema con en nobre
	 */

	public Movimiento(String nombre, boolean importeFijo, float importe, LocalDate fecha, int codigoMovimiento) throws NombreInvalidoExceptions {
		super(nombre);
		this.importeFijo = importeFijo;
		this.importe = importe;
		this.fecha = fecha;
		codigoMovimiento = codigoMovimiento;

	}

	/**
	 * contructor vovio de movimiento
	 */
	public Movimiento() {
		super();
	}

	/**
	 * is de importeFijo muesra el balor
	 * @return retorna el boleano
	 */
	public boolean isImporteFijo() {
		return importeFijo;
	}

	/**
	 * setter de importew fijo le da el  valor
	 * @param importeFijo  es el valor que tendra 
	 */

	public void setImporteFijo(boolean importeFijo) {
		this.importeFijo = importeFijo;
	}

	/**
	 * getter de importe Se encarga de mostrar EL VALOR
	 * @return debuelve el valor
	 */
	public float getImporte() {
		return importe;
	}

	/**
	 * setter de importe da el valo al importe 
	 * @param importe es el valor que tendra
	 */
	public void setImporte(float importe) {
		this.importe = importe;
	}

	/**
	 * getter de fecha devuelve el valor
	 * @return retorna el valor 
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * setter de fecha  da el valor a la fecha
	 * @param fecha es el velor que tendra
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * getter de codigo de movimeto muetra el valor q tendra movimiento
	 * @return retorna el valor
	 */
	public int getCodigoMovimiento() {
		return codigoMovimiento;
	}

	/**
	 * setter de miviento se encarga de dar el valor
	 * @param codigoMovimiento es el valor en si
	 */
	public void setCodigoMovimiento(int codigoMovimiento) {
		codigoMovimiento = codigoMovimiento;
	}

}
