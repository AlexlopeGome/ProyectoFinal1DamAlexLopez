package clases;

import java.time.LocalDate;

public class GastoExtra extends EntidadConNombre {
	
	private boolean importeFijo;
	private float importe;
	private LocalDate fecha;
	
	public GastoExtra(String nombre, boolean importeFijo, float importe, LocalDate fecha) {
		super(nombre);
		this.importeFijo = importeFijo;
		this.importe = importe;
		this.fecha = fecha;
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
	@Override
	public String toString() {
		return "Movimiento [importeFijo=" + importeFijo + ", importe=" + importe + ", fecha=" + fecha + "]";
	}

}
