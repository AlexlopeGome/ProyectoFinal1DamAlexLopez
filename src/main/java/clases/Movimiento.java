package clases;

import java.time.LocalDate;

public class Movimiento extends EntidadConNombre {
	
	protected boolean importeFijo;
	protected float importe;
	protected LocalDate fecha;
	protected  int codigoMovimiento;
	public Movimiento(String nombre, boolean importeFijo, float importe, LocalDate fecha, int codigoMovimiento) {
		super(nombre);
		this.importeFijo = importeFijo;
		this.importe = importe;
		this.fecha = fecha;
		codigoMovimiento = codigoMovimiento;
		
		
		
	}
	public Movimiento() {
		super();
	}
	public boolean isImporteFijo() {
		return importeFijo;
	}
	public void setImporteFijo(boolean importeFijo) {
		this.importeFijo = importeFijo;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getCodigoMovimiento() {
		return codigoMovimiento;
	}
	public void setCodigoMovimiento(int codigoMovimiento) {
		codigoMovimiento = codigoMovimiento;
	}
	@Override
	public String toString() {
		return "Movimiento [importeFijo=" + importeFijo + ", importe=" + importe + ", fecha=" + fecha
				+ ", CodigoMovimiento=" + codigoMovimiento + "]";
	}
	
	

}
