package clases;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import enums.TipoCompra;
import exepciones.ContraseniaVaciaException;
import utils.UtilsDB;

public class Compra extends Gastos {
	
private TipoCompra tipo;
private String tipoC;
private String comentario;	
	
public Compra(String nombre, boolean importeFijo, float importe, LocalDate fecha,String comentario, TipoCompra tipoC,
			int codigoMovimiento) throws SQLException {
		super(nombre, importeFijo, importe, fecha, codigoMovimiento);
		this.comentario = comentario;
		
Statement query=UtilsDB.conectarBD();
		
		if(query.executeUpdate(
				
		"insert into compra values('"+nombre+"',"+importeFijo+","+importe+",'"+ fecha + "','"+ comentario+"','"+tipoC+"',"+codigoMovimiento+")") > 0) {
			System.out.println("Compra inserada con exito");
		
			//Si la inserción en BD ha colado, ya podemos modificar las
			//Variables internas con la tranquilidad de que en BD
			//También existen.
			this.nombre=nombre;
			this.importeFijo = importeFijo;
			this.importe = importe;
			this.fecha = fecha;
			this.comentario = comentario;
			this.tipo = tipo;
			this.codigoMovimiento=codigoMovimiento;
			
		}else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
	UtilsDB.desconectarBD();
		
		
	}
		
	public String getTipoC() {
	return tipoC;
}

public void setTipoC(String tipoC) {
	this.tipoC = tipoC;
}

	public Compra() {
		
	}

public Compra(LocalDate fecha) throws SQLException {
	super();
	

	Statement query=UtilsDB.conectarBD();
	ResultSet datosDevueltos=query.executeQuery("select * from compra where fecha='"+fecha+"'");
	if(datosDevueltos.next()) {
		
		nombre=datosDevueltos.getString("nombre");
		importeFijo = datosDevueltos.getBoolean("importeFijo");
		importe=datosDevueltos.getFloat("importe");
		fecha = datosDevueltos.getDate("fecha").toLocalDate();
		tipoC =datosDevueltos.getString("tipoCompra");
		this.comentario = datosDevueltos.getString("comentario");
		
		
	}else {
		throw new SQLException("la compra no existe");
	}

}



public TipoCompra getTipo() {
	return tipo;
}



public void setTipo(TipoCompra tipo) {
	this.tipo = tipo;
}




public String getComentario() {
	return comentario;
}
public void setComentario(String comentario) {
	this.comentario = comentario;
}
@SuppressWarnings("null")
public boolean eliminarCompra() {
    Statement smt = UtilsDB.conectarBD();
    boolean ret;
 
    try {
        ret = smt.executeUpdate("delete from compra where nombre='" + nombre + "'") > 0;

        nombre=null;
        this.importeFijo = null != null;
		this.importe = (Float) null;
		this.fecha = null;
		this.tipoC = null;
		this.comentario = null;
        
        
        
    } catch (SQLException e) {
        // e.printStackTrace();
        UtilsDB.desconectarBD();
        return false;
    }
    UtilsDB.desconectarBD();
    return ret;
}
public static ArrayList<Compra> getTodasCompras(){
	Statement smt=UtilsDB.conectarBD();
//Inicializamos un ArrayList para devolver
		ArrayList<Compra> ret=new ArrayList<Compra>();
		
		try {
			
			ResultSet cursor=smt.executeQuery("select * from compra");
			while(cursor.next()) {
		
				Compra actual=new Compra();
				
				actual.nombre=cursor.getString("nombre");
				actual.importeFijo = cursor.getBoolean("importeFijo");
    			actual.importe = cursor.getFloat("importe");
    			actual.fecha=cursor.getDate("fecha").toLocalDate();
    			actual.fecha = cursor.getDate("fecha").toLocalDate();
    			actual.tipoC=cursor.getString("tipoCompras");
    			actual.comentario= cursor.getString("comentario");
                
				 			
    			
    			
    			
    			
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



@Override
public String toString() {
	return "Compra [tipoCompra=" + tipoC + ", comentario=" + comentario + "]";
}
}
