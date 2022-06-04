package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.TipoActividadDesenpeniada;
import utils.UtilsDB;

public class Trabajador extends EntidadConNombre {

private int telefono;
private String activi;
private TipoActividadDesenpeniada  actividadDesempe�ada;
public Trabajador(String nombre, int telefono, TipoActividadDesenpeniada activi) throws SQLException {
	super(nombre);
	this.telefono = telefono;
	this.actividadDesempe�ada = actividadDesempe�ada;

	Statement query=UtilsDB.conectarBD();
	
	
	if(query.executeUpdate(
			"insert into usuario values('"+nombre+"',"+telefono+",'"+activi+"')") > 0) {
				System.out.println("Trabajador inserado con exito");
				//Si la inserción en BD ha colado, ya podemos modificar las
				//Variables internas con la tranquilidad de que en BD
				//También existen.
				this.nombre=nombre;
				this.telefono = telefono;
				this.actividadDesempe�ada = actividadDesempe�ada;;
			}else {
				throw new SQLException("No se ha podido insertar el usuario");
				
			}
			
			UtilsDB.desconectarBD();
			
			
		}
	
	
	
	






public Trabajador(int telefono) throws SQLException {
	super();
	this.telefono = telefono;
	
	
	Statement query=UtilsDB.conectarBD();
	ResultSet datosDevueltos=query.executeQuery("select * from compra where fecha='"+telefono+"'");
	if(datosDevueltos.next()) {
		
		nombre=datosDevueltos.getString("nombre");
		telefono=datosDevueltos.getInt("telefono");
		activi=datosDevueltos.getString("actividadDesempe�ada");
		
		
	}else {
		throw new SQLException("el trabajador no existe");
	}


	
	
}


public Trabajador() {
	// TODO Auto-generated constructor stub
}
public int getTelefono() {
	return telefono;
}
public void setTelefono(int telefono) {
	this.telefono = telefono;
}
public TipoActividadDesenpeniada getActividadDesempe�ada() {
	return actividadDesempe�ada;
}
public void setActividadDesempe�ada(TipoActividadDesenpeniada actividadDesempe�ada) {
	this.actividadDesempe�ada = actividadDesempe�ada;
}	
	

@SuppressWarnings("null")
public boolean eliminarCompra() {
    Statement smt = UtilsDB.conectarBD();
    boolean ret;
 
    try {
        ret = smt.executeUpdate("delete from Trabajador where nombre='" + nombre + "'") > 0;

        this.nombre=null;
        this.telefono =0;
        this.actividadDesempe�ada = null;
        
        
        
    } catch (SQLException e) {
        // e.printStackTrace();
        UtilsDB.desconectarBD();
        return false;
    }
    UtilsDB.desconectarBD();
    return ret;
}

public static ArrayList<Trabajador> getTodostrabajdores(){
	Statement smt=UtilsDB.conectarBD();
//Inicializamos un ArrayList para devolver
		ArrayList<Trabajador> ret=new ArrayList<Trabajador>();
		
		try {
			
			ResultSet cursor=smt.executeQuery("select * from Trabajador");
			while(cursor.next()) {
		
				Trabajador actual=new Trabajador();
				
				actual.nombre=cursor.getString("nombre");
				actual.telefono = cursor.getInt("telefono");
    			actual.activi = cursor.getString("actividadDesempe�ada");
    	
    			
    			
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
