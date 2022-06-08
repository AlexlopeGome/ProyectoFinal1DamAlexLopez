package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import Utils.UtilsDB;
import exepciones.ContraseniaIncorrectaException;
import exepciones.ContraseniaVaciaException;
import exepciones.CorreoInvalidoException;
import exepciones.FechaInvalidoNacimientoException;
import exepciones.NickInvalidoExceptions;
import exepciones.UsuarioNoExisteException;

public class Usuario extends EntidadConNombre {
	
	private String apellidos;
	private String correo;
	private String contrasenia;
	private LocalDate fechaNacimiento;
	private String numeroHijos;
	private String direccion;
	private String nick;

	private boolean contraseniaValida(String contrasenia) {
		return !contrasenia.isBlank();
	}
	
	
	private boolean correoValido(String correo) {
		return correo.contains("@");
	}
	
	public Usuario(String nombre, String apellidos,String correo,String contrasenia, LocalDate fechaNacimiento,String numeroHijos,String direccion,
			String nick) throws ContraseniaVaciaException, CorreoInvalidoException, SQLException {
		super(nombre);
	
		
		if(!this.contraseniaValida(contrasenia)) {
			throw new ContraseniaVaciaException("La contraseÒa no puede estar vacÌa");
		}
		
		if(!this.correoValido(correo)) {
			throw new CorreoInvalidoException("El mail no es valido");
		}
		
		Statement query=UtilsDB.conectarBD();
		

		if(query.executeUpdate(
		"insert into usuario values('"+nombre+"','"+apellidos+"','"+correo+"','"+
		contrasenia+"','"+ fechaNacimiento + "','"+numeroHijos+"','"+direccion+"','"+nick+"')") > 0) {
			System.out.println("Usuario inserado con exito");
			//Si la inserci√≥n en BD ha colado, ya podemos modificar las
			//Variables internas con la tranquilidad de que en BD
			//Tambi√©n existen.
			this.nombre=nombre;
			this.apellidos = apellidos;
			this.numeroHijos = numeroHijos;
			this.fechaNacimiento = fechaNacimiento;
			this.contrasenia = contrasenia;
			this.direccion = direccion;
			this.correo = correo;
			this.nick=nick;
		}else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		
		UtilsDB.desconectarBD();
		
		
	}

	public Usuario(String nick) throws SQLException {
		super();
		
		
		Statement query=UtilsDB.conectarBD();
		ResultSet datosDevueltos=query.executeQuery("select * from usuario where nick='"+nick+"'");
		if(datosDevueltos.next()) {
			
			
			this.nombre=datosDevueltos.getString("nombre");
			this.apellidos = datosDevueltos.getString("apellidos");
			this.fechaNacimiento = datosDevueltos.getDate("fechaNacimiento").toLocalDate();
			this.contrasenia=datosDevueltos.getString("contrasenia");
			this.direccion = datosDevueltos.getString("direccion");
			this.correo = datosDevueltos.getString("correo");
			this.numeroHijos = datosDevueltos.getString("numehijos"); 
			this.nick= datosDevueltos.getString("nick");
			
			
		}else {
			throw new SQLException("El usuario no existe");
		}
	}
	public Usuario(String nick, String contrasenia) throws ContraseniaIncorrectaException, UsuarioNoExisteException, SQLException {
		super();
		
		  Statement smt=UtilsDB.conectarBD();

	        ResultSet cursor=smt.executeQuery("select * from usuario where nick='"+nick+"'");

	        //Aqu√≠ podemos usar if en vez de while porque si el nombre est√°, solo va a estar

	        //una vez, porque es la PK

	        if(cursor.next()) {
	        	
	  

	                this.contrasenia=cursor.getString("contrasenia");

	                if(!this.contrasenia.equals(contrasenia)) {
	                	
	                
	                        UtilsDB.desconectarBD();

	                        throw new ContraseniaIncorrectaException("La contraseÒa no es correcta");

	                }

	            	nombre=cursor.getString("nombre");
	    			this.apellidos = cursor.getString("apellidos");
	    			this.correo = cursor.getString("correo");
	    			this.contrasenia=cursor.getString("contrasenia");
	    			this.fechaNacimiento = cursor.getDate("fechaNacimiento").toLocalDate();
	    			this.contrasenia=cursor.getString("contrasenia");
	    			this.numeroHijos = cursor.getString("numerohijos"); 
	    			this.direccion = cursor.getString("direccion");
	    			this.nick= cursor.getString("nick");
	    			
	    			
	        }else {

	        	  UtilsDB.desconectarBD();

	                throw new UsuarioNoExisteException("El usuario no existe");

	        }

	        UtilsDB.desconectarBD();
	}
	
	

	public Usuario() {
		super();
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
                "update usuario set fechaNacimiento='" + fechaNacimiento + "' where nick='" + nick + "'") > 0) {
            this.fechaNacimiento = fechaNacimiento;
        }
		UtilsDB.desconectarBD();
		
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) throws ContraseniaVaciaException, SQLException {
			if(!this.contraseniaValida(contrasenia)) {
				throw new ContraseniaVaciaException("La contraseÒa no puede estar vacÌa");
			}
			Statement smt2=UtilsDB.conectarBD();
			if(smt2.executeUpdate("update usuario set contrasenia='"+contrasenia+
				"' where nick='"+this.nick+"'")>0){
				this.contrasenia = contrasenia;
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
			
		if(	smt1.executeUpdate("update usuario set correo='"+correo+
				"' where nick='"+this.nick+"'")>0){
			this.correo = correo;
				}
			UtilsDB.desconectarBD();
			///aquiiiir cambIANDO
		}

		
	
	public String getNumehijos() {
		return numeroHijos;
	}
	public void setNumehijos(String numehijos) throws SQLException {

			this.numeroHijos = numehijos;
	  
	}

	public String getNick() {
		
		
		return nick;
	}

	public void setNick(String nick) throws SQLException,NickInvalidoExceptions {
		
		
			
			Statement smt=UtilsDB.conectarBD();
			if (smt.executeUpdate("update usuario set nick='" + nick + "' where nick='" + this.nick + "'") > 0) {
				this.nick = nick;
		    }
				
			
				UtilsDB.desconectarBD();
	
		
	}
	
	public boolean eliminar() {
        Statement smt = UtilsDB.conectarBD();
        boolean ret;
        // El borrado lo hacemos con la PK para no equivocarnos y borrar lo que no es
        try {
            ret = smt.executeUpdate("delete from usuario where nombre='" + nombre + "'") > 0;
            // no nos queda m√°s remedio que borrar todas las variables internas
            // porque aqui el objeto no se puede poner a null, no tendr√≠a efecto en el main
            
            nombre=null;
			this.apellidos = null;
			this.fechaNacimiento = null;
			this.contrasenia=null;
			this.direccion = null;
			this.correo = null;
			this.numeroHijos = null; 
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
			
					Usuario actual=new Usuario();
					
					actual.nombre=cursor.getString("nombre");
	    			actual.apellidos = cursor.getString("apellidos");
	    			actual.correo = cursor.getString("correo");
	    			actual.contrasenia=cursor.getString("contrasenia");
	    			actual.fechaNacimiento = cursor.getDate("fechaNacimiento").toLocalDate();
	    			actual.contrasenia=cursor.getString("contrasenia");
	    			actual.numeroHijos = cursor.getString("numeroHijos");
	    			actual.direccion=cursor.getNString("direccion");
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
		return " "+ nombre +"" + apellidos + ", con correo:" + correo + " con fechaNacimiento:" + fechaNacimiento + " numeroHijos: " + numeroHijos + ", con direccion :" + direccion
				+ ".";
	}
	
	
	
	
	
}
