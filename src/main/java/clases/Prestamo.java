package clases;

import java.time.LocalDate;

public class Prestamo extends Gastos {
	
private byte porcentajeInteres;
private LocalDate fechaFin;
	
	
public Prestamo(String nombre, boolean importeFijo, float importe, LocalDate fecha, byte porcentajeInteres,
			LocalDate fechaFin,int codigoMovimiento) {
		super(nombre, importeFijo, importe, fecha,codigoMovimiento);
		this.porcentajeInteres = porcentajeInteres;
		this.fechaFin = fechaFin;
	}

public byte getPorcentajeInteres() {
	return porcentajeInteres;
}
public void setPorcentajeInteres(byte porcentajeInteres) {
	this.porcentajeInteres = porcentajeInteres;
}
public LocalDate getFechaFin() {
	return fechaFin;
}
public void setFechaFin(LocalDate fechaFin) {
	this.fechaFin = fechaFin;
}
@Override
public String toString() {
	return "Prestamo [porcentajeInteres=" + porcentajeInteres + ", fechaFin=" + fechaFin + "]";
}
}
