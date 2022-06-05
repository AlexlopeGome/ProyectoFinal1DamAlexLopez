package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import enums.Clases;
import enums.DiasSemana;
import enums.TipoActividadDesenpeniada;
import utils.UtilsDB;

public class Extraescolar extends Gastos{
	private Clases clase;
	private String claseC; 
	private DiasSemana diasSemana;
	private String diasSemanaD;
	private String nombreProfesor;
	
	
	public Extraescolar(String nombre, boolean importeFijo, float importe, LocalDate fecha, String nombreProfesor ,Clases clase,DiasSemana diasSemana,int codigoMovimiento) throws SQLException {
		super(nombre, importeFijo, importe, fecha, codigoMovimiento);
		
		Statement query=UtilsDB.conectarBD();
		if(query.executeUpdate(
		"insert into extraescolar values('"+nombre+"',"+importeFijo+","+importe+",'"+ fecha + "','"+ nombreProfesor+"','"+claseC+"','"+diasSemanaD+"',"+codigoMovimiento+")") > 0) {
			System.out.println("Actividad extraescolar inserada con exito");
		
		this.nombre=nombre;
		this.importeFijo=importeFijo;
		this.importe=importe;
		this.fecha=fecha;
		this.nombreProfesor=nombreProfesor;
		this.clase = clase;
		this.diasSemana = diasSemana;
		this.codigoMovimiento=codigoMovimiento;
		
		
		}else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		
		
		
	
		
		UtilsDB.desconectarBD();
	}
	public Extraescolar(String nombre) throws SQLException {
		super();
		this.clase = clase;
		
		Statement query=UtilsDB.conectarBD();
		ResultSet datosDevueltos=query.executeQuery("select * from extraescolar where fecha='"+fecha+"'");
		if(datosDevueltos.next()) {
			
			nombre=datosDevueltos.getString("nombre");
			importeFijo=datosDevueltos.getBoolean("importeFijo");
			importe=datosDevueltos.getFloat("importe");;
			nombreProfesor=datosDevueltos.getString("nombreProfesor");
			claseC=datosDevueltos.getString("asignaturas");
			diasSemanaD=datosDevueltos.getString("diasSemana");
			codigoMovimiento=datosDevueltos.getInt(codigoMovimiento);
			
			
		}else {
			throw new SQLException("la compra no existe");
		}
		
	}
	
	
	public Clases getClase() {
		return clase;
	}
	public void setClase(Clases clase) {
		this.clase = clase;
	}
	public DiasSemana getDiasSemana() {
		return diasSemana;
	}
	public void setDiasSemana(DiasSemana diasSemana) {
		this.diasSemana = diasSemana;
	}
	public String getNombreProfesor() {
		return nombreProfesor;
	}
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}
	@Override
	public String toString() {
		return "Extraescolar [clase=" + clase + ", diasSemana=" + diasSemana + ", nombreProfesor=" + nombreProfesor
				+ "]";
	}
	

	
	
}
