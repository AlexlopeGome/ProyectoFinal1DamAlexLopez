package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import utils.UtilsDB;

public class GastoExtra extends Gastos {

	
	public GastoExtra(String nombre, boolean importeFijo, float importe, LocalDate fecha, int codigoMovimiento) throws SQLException {
		super(nombre, importeFijo, importe, fecha, codigoMovimiento);
		// TODO Auto-generated constructor stub
	
	
	Statement query=UtilsDB.conectarBD();
	
	if(query.executeUpdate(
			
			
			"insert into GastoExtra values('"+nombre+"',"+importeFijo+","+importe+",'"+ fecha + "',"+codigoMovimiento+")") > 0) {
		System.out.println("Gasto extra  inserado con exito");
	
		//Si la inserción en BD ha colado, ya podemos modificar las
		//Variables internas con la tranquilidad de que en BD
		//También existen.
		this.nombre=nombre;
		this.importeFijo = importeFijo;
		this.importe = importe;
		this.fecha = fecha;
		
		
	}else {
		throw new SQLException("No se ha podido insertar el usuario");
	}
UtilsDB.desconectarBD();
	
	
}
	public GastoExtra() {
		super();
		
	}

	public GastoExtra(LocalDate fecha) throws SQLException {
		super();
		

		Statement query=UtilsDB.conectarBD();
		ResultSet datosDevueltos=query.executeQuery("select * from compra where fecha='"+fecha+"'");
		if(datosDevueltos.next()) {
			
			nombre=datosDevueltos.getString("nombre");
			importeFijo = datosDevueltos.getBoolean("importeFijo");
			importe=datosDevueltos.getFloat("importe");
			fecha = datosDevueltos.getDate("fecha").toLocalDate();
			
			
			
		}else {
			throw new SQLException("la compra no existe");
		}

	}

	@SuppressWarnings("null")
	public boolean eliminarGastoExtra() {
	    Statement smt = UtilsDB.conectarBD();
	    boolean ret;
	 
	    try {
	        ret = smt.executeUpdate("delete from GastoEtra where nombre='" + nombre + "'") > 0;

	        nombre=null;
	        this.importeFijo = null != null;
			this.importe = (Float) null;
			this.fecha = null;
			
	        
	        
	        
	    } catch (SQLException e) {
	        // e.printStackTrace();
	        UtilsDB.desconectarBD();
	        return false;
	    }
	    UtilsDB.desconectarBD();
	    return ret;
	}
	public static ArrayList<GastoExtra> getTodosGastosExtra(){
		Statement smt=UtilsDB.conectarBD();
	//Inicializamos un ArrayList para devolver
			ArrayList<GastoExtra> ret=new ArrayList<GastoExtra>();
			
			try {
				
				ResultSet cursor=smt.executeQuery("select * from GastoExtra");
				while(cursor.next()) {
			
					GastoExtra actual=new GastoExtra();
					
					actual.nombre=cursor.getString("nombre");
					actual.importeFijo = cursor.getBoolean("importeFijo");
	    			actual.importe = cursor.getFloat("importe");
	    			actual.fecha=cursor.getDate("fecha").toLocalDate();
	    			actual.fecha = cursor.getDate("fecha").toLocalDate();
	    
	                
					 			
	    			
	    			
	    			
	    			
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

	
	

}
