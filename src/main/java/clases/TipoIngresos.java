package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.google.protobuf.Enum;

import Utils.UtilsDB;
import enums.TipoIngreso;

public class TipoIngresos extends Ingresos {
	
	private TipoIngreso Ingreso;
	private String ingresoT;

	public TipoIngresos(String nombre, boolean importeFijo, float importe, LocalDate fecha, TipoIngreso ingresoT,
			int codigoMovimiento) throws SQLException {
		super(nombre, importeFijo, importe, fecha,codigoMovimiento);
		

		
Statement query=UtilsDB.conectarBD();
		
		if(query.executeUpdate(
				
		"insert into tipoIngreso values('"+nombre+"',"+importeFijo+","+importe+",'"+ fecha + "','"+ingresoT+"',"+codigoMovimiento+")") > 0) {
			System.out.println("Ingreso inserado con exito");
		
			//Si la inserción en BD ha colado, ya podemos modificar las
			//Variables internas con la tranquilidad de que en BD
			//También existen.
			this.nombre=nombre;
			this.importeFijo = importeFijo;
			this.importe = importe;
			this.fecha = fecha;
			this.Ingreso =Ingreso;
			this.codigoMovimiento=codigoMovimiento;
			
		}else {
			throw new SQLException("No se ha podido insertar el ingreso ");
		}
	UtilsDB.desconectarBD();
		
		
	}

	public TipoIngreso getIngreso() {
		return Ingreso;
	}

	public void setIngrerso(TipoIngreso ingrerso) {
		Ingreso = ingrerso;
	}

	public String getIngresoT() {
		return ingresoT;
	}

	public void setIngresoT(String ingresoT) {
		this.ingresoT = ingresoT;
	}
		public  TipoIngresos() {
			
		}
	public boolean eliminarIngreso() {
	    Statement smt = UtilsDB.conectarBD();
	    boolean ret;
	 
	    try {
	        ret = smt.executeUpdate("delete from tipoIngreso where nombre='" + nombre + "'") > 0;

	        nombre=null;
	        this.importeFijo = null != null;
			this.importe =0;
			this.fecha = null;
			this.Ingreso =null;
	        this.codigoMovimiento=0;
	        
	        
	    } catch (SQLException e) {
	        // e.printStackTrace();
	        UtilsDB.desconectarBD();
	        return false;
	    }
	    UtilsDB.desconectarBD();
	    return ret;
	}
	public static ArrayList<TipoIngresos> getTodosIngresos(){
		Statement smt=UtilsDB.conectarBD();
	//Inicializamos un ArrayList para devolver
			ArrayList<TipoIngresos> ret=new ArrayList<TipoIngresos>();
			
			try {
				
				ResultSet cursor=smt.executeQuery("select * from tipoIngreso");
				while(cursor.next()) {
			
					TipoIngresos actual=new TipoIngresos();
					
					actual.nombre=cursor.getString("nombre");
					actual.importeFijo = cursor.getBoolean("importeFijo");
	    			actual.importe = cursor.getFloat("importe");
	    			actual.fecha=cursor.getDate("fecha").toLocalDate();
	    			actual.ingresoT=cursor.getNString("tipoIngreso");
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
		File archivo = new File("./Informes/InformeIngresos.txt");
	    if (archivo.exists()) {
	        archivo.delete();
	    }
	    archivo.createNewFile();
	    FileWriter escritor = new FileWriter(archivo,true);
	    ArrayList<TipoIngresos> informe=getTodosIngresos();
	    
	    for (int i=0 ;i<informe.size();i++) {
	    	escritor.write(" -- ");;
	    	escritor.write("Nombre. "+informe.get(i).getNombre());
	      	escritor.write(" Importe. "+ informe.get(i).getImporte());
	      	escritor.write("Tipo Ingreso."+informe.get(i).getIngresoT()+"\n");
	      	
	    }
	    escritor.flush();
	    escritor.close();
	}

	
}


