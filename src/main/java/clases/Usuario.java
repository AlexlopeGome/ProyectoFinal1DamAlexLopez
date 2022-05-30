package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
	private byte numehijos;
	private String nick;
	
	private boolean contraseniaValida(String pass) {
		return !pass.isBlank();
	}
	private boolean correoValido(String email) {
		return email.contains("@");
	}
	
	public Usuario(String nombre, String apellidos, LocalDate fechaNacimiento, int contrenia, String direccion,
			String correo, byte numehijos,String nick) throws ContraseniaVaciaException, CorreoInvalidoException, SQLException {
		super(nombre);
		
	
		
		
		
		
		if(!this.contraseniaValida(contrasenia)) {
			throw new ContraseniaVaciaException("La contraseña no puede estar vacía");
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
			//Si la inserciÃ³n en BD ha colado, ya podemos modificar las
			//Variables internas con la tranquilidad de que en BD
			//TambiÃ©n existen.
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
			this.numehijos = datosDevueltos.getByte("numehijos"); 
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

	        //AquÃ­ podemos usar if en vez de while porque si el nombre estÃ¡, solo va a estar

	        //una vez, porque es la PK

	        if(datosDevueltos.next()) {

	                this.contrasenia=datosDevueltos.getString("contrasena");

	                if(!this.contrasenia.equals(contrasenia)) {

	                        UtilsDB.desconectarBD();

	                        throw new ContraseniaIncorrectaException("La contraseña no es correcta");

	                }

	            	
	            	this.nombre=datosDevueltos.getString("nombre");
	    			this.apellidos = datosDevueltos.getString("apellidos");
	    			this.fechaNacimiento = datosDevueltos.getDate("fechaNacimiento").toLocalDate();
	    			this.contrasenia=datosDevueltos.getString("contrasena");
	    			this.direccion = datosDevueltos.getString("direccion");
	    			this.correo = datosDevueltos.getString("correo");
	    			this.numehijos = datosDevueltos.getByte("numehijos"); 
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
				throw new ContraseniaVaciaException("La contraseña no puede estar vacía");
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

		
	
	public byte getNumehijos() {
		return numehijos;
	}
	public void setNumehijos(byte numehijos) {
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

	@Override
	public String toString() {
		return "Usuario [apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", contrenia=" + contrasenia
				+ ", direccion=" + direccion + ", correo=" + correo + ", numehijos=" + numehijos + ",nick= "+nick +"]";
	}
	
	
	
	
}
