package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import Utils.UtilsDB;

public class Prestamo extends Gastos {
	
private Float porcentajeInteres;
private LocalDate fechaFin;
	
	
public Prestamo(String nombre, boolean importeFijo, float importe, LocalDate fecha, float porcentajeInteres,
			LocalDate fechaFin,int codigoMovimiento) throws SQLException {
		super(nombre, importeFijo, importe, fecha,codigoMovimiento);

		Statement query=UtilsDB.conectarBD();
		if(query.executeUpdate(
		"insert into Prestamo values('"+nombre+"',"+importeFijo+","+importe+",'"+ fecha + "',"+ porcentajeInteres+",'"+fechaFin+"',"+codigoMovimiento+")") > 0) {
			System.out.println("Actividad extraescolar inserada con exito");
		
		this.nombre=nombre;
		this.importeFijo=importeFijo;
		this.importe=importe;
		this.fecha=fecha;
		this.porcentajeInteres=porcentajeInteres;
		this.fechaFin=fechaFin;
		this.codigoMovimiento=codigoMovimiento;
		
		
		}else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		
		
	}





public Float getPorcentajeInteres() {
	return porcentajeInteres;
}
public void setPorcentajeInteres(Float porcentajeInteres) {
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
