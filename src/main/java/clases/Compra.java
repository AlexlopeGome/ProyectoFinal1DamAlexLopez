package clases;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import exepciones.ContraseniaVaciaException;
import utils.UtilsDB;

public class Compra extends Gastos {
	
private ArrayList tipoCompra;
private String comentario;	
	
public Compra(String nombre, boolean importeFijo, float importe, LocalDate fecha, ArrayList tipoCompra,
			String comentario) throws SQLException {
		super(nombre, importeFijo, importe, fecha);
		this.tipoCompra = tipoCompra;
		this.comentario = comentario;
		
Statement query=UtilsDB.conectarBD();
		

		if(query.executeUpdate(
		"insert into compra values('"+nombre+"','"+importeFijo+"','"+importe+"','"+ fecha + "','"+tipoCompra+"','"+comentario+"')") > 0) {
			System.out.println("Compra inserada con exito");
			//Si la inserción en BD ha colado, ya podemos modificar las
			//Variables internas con la tranquilidad de que en BD
			//También existen.
			this.nombre=nombre;
			this.importeFijo = importeFijo;
			this.importe = importe;
			this.fecha = fecha;
			this.tipoCompra = tipoCompra;
			this.comentario = comentario;
			
		}else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
	UtilsDB.desconectarBD();
		
		
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
		this.tipoCompra =(ArrayList) datosDevueltos.getArray("tipoCompra");
		this.comentario = datosDevueltos.getString("comentario");
		
		
	}else {
		throw new SQLException("la compra no existe");
	}

}


public ArrayList getTipoCompra() {
	return tipoCompra;
}
public void setTipoCompra(ArrayList tipoCompra) {
	this.tipoCompra = tipoCompra;
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
		this.tipoCompra = null;
		this.comentario = null;
        
        
        
    } catch (SQLException e) {
        // e.printStackTrace();
        UtilsDB.desconectarBD();
        return false;
    }
    UtilsDB.desconectarBD();
    return ret;
}






@Override
public String toString() {
	return "Compra [tipoCompra=" + tipoCompra + ", comentario=" + comentario + "]";
}
}
