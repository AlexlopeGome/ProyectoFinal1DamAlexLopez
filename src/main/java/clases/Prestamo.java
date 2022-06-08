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

public class Prestamo extends Gastos {
	
private Float porcentajeInteres;
private LocalDate fechaFin;
	
	
public Prestamo(String nombre, boolean importeFijo, float importe, LocalDate fecha, float porcentajeInteres,
			LocalDate fechaFin,int codigoMovimiento) throws SQLException {
		super(nombre, importeFijo, importe, fecha,codigoMovimiento);

		Statement query=UtilsDB.conectarBD();
		if(query.executeUpdate(
		"insert into Prestamo values('"+nombre+"',"+importeFijo+","+importe+",'"+ fecha + "',"+ porcentajeInteres+",'"+fechaFin+"',"+codigoMovimiento+")") > 0) {
			System.out.println("Prestamo inserada con exito");
		
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


Prestamo(){
	
}

@SuppressWarnings("null")
public boolean eliminarPrestamo() {
    Statement smt = UtilsDB.conectarBD();
    boolean ret;
 
    try {
        ret = smt.executeUpdate("delete from Prestamo where nombre='" + nombre + "'") > 0;

		this.nombre=null;
		this.importeFijo=null != null;
		this.importe=0;
		this.fecha=null;
		this.porcentajeInteres=null;
		this.fechaFin=null;
		this.codigoMovimiento=0;
        
        
        
    } catch (SQLException e) {
        // e.printStackTrace();
        UtilsDB.desconectarBD();
        return false;
    }
    UtilsDB.desconectarBD();
    return ret;
}
public static ArrayList<Prestamo> getTodosprestamo(){
	Statement smt=UtilsDB.conectarBD();
//Inicializamos un ArrayList para devolver
		ArrayList<Prestamo> ret=new ArrayList<Prestamo>();
		
		try {
			
			ResultSet cursor=smt.executeQuery("select * from Prestamo");
			while(cursor.next()) {
		
				Prestamo actual=new Prestamo();
				
				actual.nombre=cursor.getString("nombre");
				actual.importeFijo = cursor.getBoolean("importeFijo");
    			actual.importe = cursor.getFloat("importe");
    			actual.fecha=cursor.getDate("fecha").toLocalDate();
    			actual.porcentajeInteres=cursor.getFloat("porcentaje");
    			actual.fechaFin = cursor.getDate("fecha").toLocalDate();
    			actual.codigoMovimiento=cursor.getInt("codigoMovimiento");
        
				ret.add(actual);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		UtilsDB.desconectarBD();
		//Si no hay usuarios en la tabla, va a devolver un arraylist vacío
		//Si la consulta fué erronea, se devuelve un ArrayList null, que son cosas distintas
		return ret;

}
public static void imprimeInforme() throws IOException {
	File archivo = new File("./Informes/InformeCompras.txt");
    if (archivo.exists()) {
        archivo.delete();
    }
    archivo.createNewFile();
    FileWriter escritor = new FileWriter(archivo,true);
    ArrayList<Prestamo> informe=getTodosprestamo();
    
    for (int i=0 ;i<informe.size();i++) {
    	escritor.write(" -- ");;
    	escritor.write("Nombre. "+informe.get(i).getNombre());
      	escritor.write(" Importe. "+ informe.get(i).getImporte());
      	escritor.write("Porcentaje."+ informe.get(i).getPorcentajeInteres());
      	escritor.write("Es Fijo. "+informe.get(i).isImporteFijo());
      
    }
    escritor.flush();
    escritor.close();
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
