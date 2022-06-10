package clases;

import java.time.LocalDate;

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
	 * @param nombre
	 * @param importeFijo
	 * @param importe
	 * @param fecha
	 * @param codigoMovimiento
	 */

	public Movimiento(String nombre, boolean importeFijo, float importe, LocalDate fecha, int codigoMovimiento) {
		super(nombre);
		this.importeFijo = importeFijo;
		this.importe = importe;
		this.fecha = fecha;
		codigoMovimiento = codigoMovimiento;

	}

	/**
	 * 
	 */
	public Movimiento() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	public boolean isImporteFijo() {
		return importeFijo;
	}

	/**
	 * 
	 * @param importeFijo
	 */

	public void setImporteFijo(boolean importeFijo) {
		this.importeFijo = importeFijo;
	}

	/**
	 * 
	 * @return
	 */
	public float getImporte() {
		return importe;
	}

	/**
	 * 
	 * @param importe
	 */
	public void setImporte(float importe) {
		this.importe = importe;
	}

	/**
	 * 
	 * @return
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * 
	 * @param fecha
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * 
	 * @return
	 */
	public int getCodigoMovimiento() {
		return codigoMovimiento;
	}

	/**
	 * 
	 * @param codigoMovimiento
	 */
	public void setCodigoMovimiento(int codigoMovimiento) {
		codigoMovimiento = codigoMovimiento;
	}

}
