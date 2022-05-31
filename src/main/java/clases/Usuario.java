package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


import exepciones.ContraseniaIncorrectaException;
import exepciones.ContraseniaVaciaException;
import exepciones.CorreoInvalidoException;
import exepciones.FechaInvalidoNacimientoException;
import exepciones.UsuarioNoExisteException;
import utils.UtilsDB;

public class Usuario extends EntidadConNombre {
	
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String contrasenia;
	private String direccion;
	private String correo;
	private String numehijos;
	private static String nick;
	
	private boolean contraseniaValida(String pass) {
		return !pass.isBlank();
	}
	private boolean correoValido(String email) {
		return email.contains("@");
	}
	
	public Usuario(String nombre, String apellidos, LocalDate fechaNacimiento, String contrasenia, String direccion,
			String correo, String numehijos,String nick) throws ContraseniaVaciaException, CorreoInvalidoException, SQLException {
		super(nombre);
		
	
		
		
		
		
		if(!this.contraseniaValida(contrasenia)) {
			throw new ContraseniaVaciaException("La contraseÒa no puede estar vacÌa");
		}
		if(!this.correoValido(correo)) {
			throw new CorreoInvalidoException("El mail no es valido");
		}
		
		Statement query=UtilsDB.conectarBD();
		

		if(query.executeUpdate(
		"insert into usuario values('"+  
		nombre+"','"+apellidos+"'"+fechaNacimiento+"','"+
		contrasenia+"',"+ direccion + ",'"+correo+"','"+numehijos+"','"+nick+"')") > 0) {
			System.out.println("Usuario inserado con exito");
			//Si la inserci√≥n en BD ha colado, ya podemos modificar las
			//Variables internas con la tranquilidad de que en BD
			//Tambi√©n existen.
			this.apellidos = apellidos;
			this.fechaNacimiento = fechaNacimiento;
			this.contrasenia = contrasenia;
			this.direccion = direccion;
			this.correo = correo;
			this.numehijos = numehijos;
			this.nick=nick;
		}else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
	UtilsDB.desconectarBD();
		
	
		
		
		
		
		
	}

	public Usuario(String nick) throws SQLException {
		super(nombre);
		
		
		Statement query=UtilsDB.conectarBD();
		ResultSet datosDevueltos=query.executeQuery("select * from usuario where nombre='"+nick+"'");
		if(datosDevueltos.next()) {
			
			
			this.nombre=datosDevueltos.getString("nombre");
			this.apellidos = datosDevueltos.getString("apellidos");
			this.fechaNacimiento = datosDevueltos.getDate("fechaNacimiento").toLocalDate();
			this.contrasenia=datosDevueltos.getString("contrasena");
			this.direccion = datosDevueltos.getString("direccion");
			this.correo = datosDevueltos.getString("correo");
			this.numehijos = datosDevueltos.getString("numehijos"); 
			this.nick= datosDevueltos.getString("nick");
			
			
		}else {
			throw new SQLException("El usuario no existe");
		}
	}
	public Usuario(String nick, String contrasenia) throws ContraseniaIncorrectaException, UsuarioNoExisteException, SQLException {
		super(nombre);
		this.contrasenia = contrasenia;
		
		  Statement smt=UtilsDB.conectarBD();

	        ResultSet datosDevueltos=smt.executeQuery("select * from usuario where nick='"+

	        nick+"'");

	        //Aqu√≠ podemos usar if en vez de while porque si el nombre est√°, solo va a estar

	        //una vez, porque es la PK

	        if(datosDevueltos.next()) {

	                this.contrasenia=datosDevueltos.getString("contrasena");

	                if(!this.contrasenia.equals(contrasenia)) {

	                        UtilsDB.desconectarBD();

	                        throw new ContraseniaIncorrectaException("La contraseÒa no es correcta");

	                }

	            	
	            	this.nombre=datosDevueltos.getString("nombre");
	    			this.apellidos = datosDevueltos.getString("apellidos");
	    			this.fechaNacimiento = datosDevueltos.getDate("fechaNacimiento").toLocalDate();
	    			this.contrasenia=datosDevueltos.getString("contrasena");
	    			this.direccion = datosDevueltos.getString("direccion");
	    			this.correo = datosDevueltos.getString("correo");
	    			this.numehijos = datosDevueltos.getString("numehijos"); 
	    			this.nick= datosDevueltos.getString("nick");
	        }else {

	                UtilsDB.desconectarBD();

	                throw new UsuarioNoExisteException("El usuario no existe");

	        }

	        UtilsDB.desconectarBD();
	}
	
	
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) throws FechaInvalidoNacimientoException, SQLException {
		Statement smt=UtilsDB.conectarBD();
		if(smt.executeUpdate(
                "update usuario set nombre='" + fechaNacimiento + "' where nombre='" + this.nombre + "'") > 0) {
            this.fechaNacimiento = fechaNacimiento;
        }
		UtilsDB.desconectarBD();
		
	}
	public String getContrenia() {
		return contrasenia;
	}
	public void setContresnia(String contrenia) throws ContraseniaVaciaException, SQLException {
			if(!this.contraseniaValida(contrasenia)) {
				throw new ContraseniaVaciaException("La contraseÒa no puede estar vacÌa");
			}
			Statement smt2=UtilsDB.conectarBD();
			if(smt2.executeUpdate("update usuario set contrasenia='"+contrasenia+
				"' where nick='"+this.nick+"'")>0){
				this.contrasenia = contrenia;
			}
			UtilsDB.desconectarBD();
			
		}
		
		
		
		
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) throws CorreoInvalidoException, SQLException {
		
			if(!this.correoValido(correo)) {
				throw new CorreoInvalidoException("El mail no es valido");
		}
			Statement smt1=UtilsDB.conectarBD();
			
		if(	smt1.executeUpdate("update usuario set email='"+correo+
				"' where nick='"+this.nick+"'")>0){
			this.correo = correo;
				}
			UtilsDB.desconectarBD();
			///aquiiiir cambIANDO
		}

		
	
	public String getNumehijos() {
		return numehijos;
	}
	public void setNumehijos(String numehijos) {
		this.numehijos = numehijos;
		
	}
	

	public String getNick() {
		
		
		return nick;
	}

	public void setNick(String nick) throws SQLException {
		
		
			
			Statement smt=UtilsDB.conectarBD();
			if (smt.executeUpdate("update usuario set nick='" + nick + "' where nick='" + this.nick + "'") > 0) {
				this.nick = nick;
		    }
				
				//Lo primero de todo, intentar el update. Si no funciona en BD
				//No lo hacemos en Java.
				
				//La consulta se debe de hacer modificando la variable especifica
				//del setter y haciendolo solo donde la PK coincida
				//OJO de poner en el update el valor de argumentos. Si pones el this no cambias nada
				
				UtilsDB.desconectarBD();
				
		
		
	}
	
	public boolean eliminar() {
        Statement smt = UtilsDB.conectarBD();
        boolean ret;
        // El borrado lo hacemos con la PK para no equivocarnos y borrar lo que no es
        try {
            ret = smt.executeUpdate("delete from usuario where nombre='" + this.nombre + "'") > 0;
            // no nos queda m√°s remedio que borrar todas las variables internas
            // porque aqui el objeto no se puede poner a null, no tendr√≠a efecto en el main
            
            this.nombre=null;
			this.apellidos = null;
			this.fechaNacimiento = null;
			this.contrasenia=null;
			this.direccion = null;
			this.correo = null;
			this.numehijos = null; 
			this.nick= null;
            
            
            
        } catch (SQLException e) {
            // e.printStackTrace();
            UtilsDB.desconectarBD();
            return false;
        }
        UtilsDB.desconectarBD();
        return ret;
    }
	
	
	public static ArrayList<Usuario> getTodos(){
		Statement smt=UtilsDB.conectarBD();
	//Inicializamos un ArrayList para devolver
			ArrayList<Usuario> ret=new ArrayList<Usuario>();
			
			try {
				
				ResultSet cursor=smt.executeQuery("select * from usuario");
				while(cursor.next()) {
			
	                
	                Usuario actual=new Usuario(nick);
	            	actual.nombre=cursor.getString("nombre");
	            	actual.apellidos = cursor.getString("apellidos");
	            	actual.fechaNacimiento = cursor.getDate("fechaNacimiento").toLocalDate();
	            	actual.contrasenia=cursor.getString("contrasena");
	            	actual.direccion = cursor.getString("direccion");
	            	actual.correo = cursor.getString("correo");
	            	actual.numehijos = cursor.getString("numehijos"); 
	            	actual.nick= cursor.getString("nick");
	                
					
					ret.add(actual);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			
			UtilsDB.desconectarBD();
			//Si no hay usuarios en la tabla, va a devolver un arraylist vac√≠o
			//Si la consulta fu√© erronea, se devuelve un ArrayList null, que son cosas distintas
			return ret;
		}
	@Override
	public String toString() {
		return "Usuario [apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", contrenia=" + contrasenia
				+ ", direccion=" + direccion + ", correo=" + correo + ", numehijos=" + numehijos + ",nick= "+nick +"]";
	}
	
	
	
	
}
