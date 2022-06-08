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

public class ExtraEscolar extends Gastos{
	private Clases clase;
	private String claseC; 
	private DiasSemana diasSemana;
	
	
	private String diasSemanaD;
	private String nombreProfesor;
	
	
	public ExtraEscolar(String nombre, boolean importeFijo, float importe, LocalDate fecha, String nombreProfesor ,Clases claseC,DiasSemana diasSemanaD,int codigoMovimiento) throws SQLException {
		super(nombre, importeFijo, importe, fecha, codigoMovimiento);
		
		Statement query=UtilsDB.conectarBD();
		if(query.executeUpdate(
		"insert into extraEscolar values('"+nombre+"',"+importeFijo+","+importe+",'"+ fecha + "','"+ nombreProfesor+"','"+claseC+"','"+diasSemanaD+"',"+codigoMovimiento+")") > 0) {
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
	public ExtraEscolar() {
	}
	
	public ExtraEscolar(String nombre) throws SQLException {
		super();
		this.clase = clase;
		
		Statement query=UtilsDB.conectarBD();
		ResultSet datosDevueltos=query.executeQuery("select * from extraEscolar where fecha='"+fecha+"'");
		if(datosDevueltos.next()) {
			
			nombre=datosDevueltos.getString("nombre");
			importeFijo=datosDevueltos.getBoolean("importeFijo");
			importe=datosDevueltos.getFloat("importe");
			fecha=datosDevueltos.getDate("fecha").toLocalDate();
			nombreProfesor=datosDevueltos.getString("nombreProfesor");
			claseC=datosDevueltos.getString("asignaturas");
			diasSemanaD=datosDevueltos.getString("diasSemana");
			codigoMovimiento=datosDevueltos.getInt(codigoMovimiento);
			
			
		}else {
			throw new SQLException("la compra no existe");
		}
		
	}
	
	public boolean eliminarExtraEscolar() {
	    Statement smt = UtilsDB.conectarBD();
	    boolean ret;
	 
	    try {
	        ret = smt.executeUpdate("delete from extraEscolar where nombre='" + nombre + "'") > 0;

	        this.nombre=null;
			this.importeFijo=false;
			this.importe= 0;
			this.fecha=null;
			this.nombreProfesor=null;
			this.clase = null;
			this.diasSemana = null;
			this.codigoMovimiento=0;
			
	        
	        
	        
	    } catch (SQLException e) {
	        // e.printStackTrace();
	        UtilsDB.desconectarBD();
	        return false;
	    }
	    UtilsDB.desconectarBD();
	    return ret;
	}
	public static ArrayList<ExtraEscolar> getTodosExtraEscolar(){
		Statement smt=UtilsDB.conectarBD();
	//Inicializamos un ArrayList para devolver
			ArrayList<ExtraEscolar> ret=new ArrayList<ExtraEscolar>();
			
			try {
				
				ResultSet cursor=smt.executeQuery("select * from extraescolar");
				while(cursor.next()) {
			
					ExtraEscolar actual=new ExtraEscolar();
					
					actual.nombre=cursor.getString("nombre");
					actual.importeFijo = cursor.getBoolean("importeFijo");
	    			actual.importe = cursor.getFloat("importe");
	    			actual.nombreProfesor=cursor.getString("nombreProfesor");
	    			actual.fecha=cursor.getDate("fecha").toLocalDate();
	    			actual.fecha = cursor.getDate("fecha").toLocalDate();
	    			
	    			actual.claseC=cursor.getString("asignaturas");
	    			actual.diasSemanaD=cursor.getString("diaSemana");
	    			
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
		File archivo = new File("./Informes/InformeExtraescolar.txt");
	    if (archivo.exists()) {
	        archivo.delete();
	    }
	    archivo.createNewFile();
	    FileWriter escritor = new FileWriter(archivo,true);
	    ArrayList<ExtraEscolar> informe=getTodosExtraEscolar();
	    
	    for (int i=0 ;i<informe.size();i++) {
	    	escritor.write(" -- ");;
	    	escritor.write("Nombre. "+informe.get(i).getNombre());
	      	escritor.write(" Importe. "+ informe.get(i).getImporte());
	      	escritor.write(" Tipo Clase. "+informe.get(i).getClaseC());
	      	escritor.write("Dias de la Semana. "+informe.get(i).getDiasSemanaD());
	      	escritor.write("Profesor. "+informe.get(i).getNombreProfesor());
	    }
	    escritor.flush();
	    escritor.close();
	}


	
	
	
	
	public String getClaseC() {
		return claseC;
	}
	public void setClaseC(String claseC) {
		this.claseC = claseC;
	}
	public String getDiasSemanaD() {
		return diasSemanaD;
	}
	public void setDiasSemanaD(String diasSemanaD) {
		this.diasSemanaD = diasSemanaD;
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
		return "Extraescolar [clase=" + claseC + ", diasSemana=" + diasSemanaD + ", nombreProfesor=" + nombreProfesor
				+ "]";
	}
	

	
	
}
