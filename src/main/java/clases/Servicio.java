package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import Utils.UtilsDB;
import enums.Clases;
import enums.DiasSemana;
import enums.TipoActividadDesenpeniada;

public class Servicio extends Gastos{
	
	private String diasSemanaD;
	private String nombreTrabajador;
	private DiasSemana diasSemana;
	
	

	
	
	public Servicio(String nombre, boolean importeFijo, float importe, LocalDate fecha, int codigoMovimiento,
			String diasSemanaD, String nombreTrabajador, DiasSemana diasSemana) {
		super(nombre, importeFijo, importe, fecha, codigoMovimiento);
	
	}
	
	
public Servicio (String nombre, boolean importeFijo, float importe, LocalDate fecha, String nombreTrabajador, DiasSemana diasSemanaD, int codigoMovimiento) throws SQLException {
		
	
		
		Statement query=UtilsDB.conectarBD();
		if(query.executeUpdate(
		"insert into Servicio values('"+nombre+"',"+importeFijo+","+importe+",'"+ fecha + "','"+ nombreTrabajador+"','"+diasSemanaD+"',"+codigoMovimiento+")") > 0) {
			System.out.println("Servicio inserado con exito");
	
		this.nombre=nombre;
		this.importeFijo=importeFijo;
		this.importe=importe;
		this.fecha=fecha;
		this.nombreTrabajador=nombreTrabajador;
		this.diasSemana = diasSemana;
		this.codigoMovimiento=codigoMovimiento;

		
		}else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		
		
		
	
		
		UtilsDB.desconectarBD();
	}
		
public Servicio(String nombre) throws SQLException {
	super();
	
	
	Statement query=UtilsDB.conectarBD();
	ResultSet datosDevueltos=query.executeQuery("select * from Servicio where fecha='"+fecha+"'");
	if(datosDevueltos.next()) {
		
		nombre=datosDevueltos.getString("nombre");
		importeFijo=datosDevueltos.getBoolean("importeFijo");
		importe=datosDevueltos.getFloat("importe");
		fecha=datosDevueltos.getDate("fecha").toLocalDate();
		nombreTrabajador=datosDevueltos.getString("nombreTrabajador");
		diasSemanaD=datosDevueltos.getString("diasSemana");
		codigoMovimiento=datosDevueltos.getInt(codigoMovimiento);
		
		
	}else {
		throw new SQLException("la compra no existe");
	}
	
}
		
	
	
	public Servicio(){
		
	}
	
	
	
	
	public String getDiasSemanaD() {
		return diasSemanaD;
	}
	public void setDiasSemanaD(String diasSemanaD) {
		this.diasSemanaD = diasSemanaD;
	}
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}
	public DiasSemana getDiasSemana() {
		return diasSemana;
	}
	public void setDiasSemana(DiasSemana diasSemana) {
		this.diasSemana = diasSemana;
	}
	
	public boolean eliminarServicio() {
	    Statement smt = UtilsDB.conectarBD();
	    boolean ret;
	 
	    try {
	        ret = smt.executeUpdate("delete from servicio where nombre='" + nombre + "'") > 0;

	        this.nombre=null;
			this.importeFijo=(Boolean) null;
			this.importe=(Float) null;
			this.fecha=null;
			this.nombreTrabajador=null;
			this.diasSemana = null;
			this.codigoMovimiento=(Integer) null;
			
	        
	        
	        
	    } catch (SQLException e) {
	        // e.printStackTrace();
	        UtilsDB.desconectarBD();
	        return false;
	    }
	    UtilsDB.desconectarBD();
	    return ret;
	}
	public static ArrayList<Servicio> getTodosServicio(){
		Statement smt=UtilsDB.conectarBD();
	
			ArrayList<Servicio> ret=new ArrayList<Servicio>();
			
			try {
				
				ResultSet cursor=smt.executeQuery("select * from servicio");
				while(cursor.next()) {
			
					Servicio actual=new Servicio();
					
					actual.nombre=cursor.getString("nombre");
					actual.importeFijo = cursor.getBoolean("importeFijo");
	    			actual.importe = cursor.getFloat("importe");
	    			actual.nombreTrabajador=cursor.getString("nombreTrabajador");
	    			actual.fecha=cursor.getDate("fecha").toLocalDate();	    			
	    			actual.diasSemanaD=cursor.getString("diaSemana");
	    			actual.codigoMovimiento=cursor.getInt("codigoMovimiento");

	    			
					ret.add(actual);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			
			UtilsDB.desconectarBD();
		
			return ret;

	}


	
	
	public static void imprimeInforme() throws IOException {
		File archivo = new File("./Informes/InformeServicio.txt");
	    if (archivo.exists()) {
	        archivo.delete();
	    }
	    archivo.createNewFile();
	    FileWriter escritor = new FileWriter(archivo,true);
	    ArrayList<Servicio> informe=getTodosServicio();
	    
	    for (int i=0 ;i<informe.size();i++) {
	    	escritor.write(" -- ");;
	    	escritor.write("Nombre. "+informe.get(i).getNombre());
	      	escritor.write(" Importe. "+ informe.get(i).getImporte());
	      	escritor.write("Es Fijo. "+informe.get(i).isImporteFijo());
	      	escritor.write("Nombre Trabajador"+informe.get(i).getNombreTrabajador());
	      	escritor.write("Dia de la semana"+ informe.get(i).getDiasSemana()+"\n");
	      	
	      
	    }
	    escritor.flush();
	    escritor.close();
	}

	
	

	
	
}
