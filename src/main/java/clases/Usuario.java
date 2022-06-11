package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import Utils.UtilsDB;
import exepciones.ApellidoInvalidoException;
import exepciones.ContraseniaIncorrectaException;
import exepciones.ContraseniaVaciaException;
import exepciones.CorreoInvalidoException;
import exepciones.NombreInvalidoExceptions;
import exepciones.UsuarioNoExisteException;

/**
 * Clase usuario la usuarimo para crear un nuevo usuario
 * 
 * @author AlexLopez
 *
 */
public class Usuario extends EntidadConNombre {

	private String apellidos;
	private String correo;
	private String contrasenia;
	private LocalDate fechaNacimiento;
	private String numeroHijos;
	private String direccion;
	private String nick;

	/**
	 * fincion boleana q nos debuelve un false si la contrseÒa esta Vacia
	 * 
	 * @param contrasenia corespode a la contrseÒa
	 * @return
	 */
	private boolean contraseniaValida(String contrasenia) {
		return !contrasenia.isBlank();
	}

	/**
	 * funcion boleanoa q nos debuelve tre si contiemne un a @ el correo
	 * 
	 * @param correo es el valos de correo
	 * @return
	 */
	private boolean correoValido(String correo) {
		return correo.contains("@");
	}

	/**
	 * 
	 * @param nombre          nombre del nuevo usuario
	 * @param apellidos       apeelido del nuevo usuario
	 * @param correo          correo del nuevo usuario
	 * @param contrasenia     contraseÒa del nuevo usuario
	 * @param fechaNacimiento fecha de nacimiento del nuevo usuario
	 * @param numeroHijos     numero de hijop del usuario
	 * @param direccion       direccion del usuaro
	 * @param nick            nick del usuario
	 * @throws ContraseniaVaciaException           verificacion contraepor exepcion
	 * @throws CorreoInvalidoExceptionverificacion por exepcion
	 * @throws SQLExceptionverificacion            por exepcion
	 * @throws NombreInvalidoExceptions            nos salta la exepcion si el
	 *                                             nombre no es valido
	 * 
	 * @throws ApellidoInvalidoException           nos salta la exepcion si el
	 *                                             Apellido no es valido
	 */
	public Usuario(String nombre, String apellidos, String correo, String contrasenia, LocalDate fechaNacimiento,
			String numeroHijos, String direccion, String nick) throws ContraseniaVaciaException,
			CorreoInvalidoException, SQLException, NombreInvalidoExceptions, ApellidoInvalidoException {
		super(nombre);

		if (!this.contraseniaValida(contrasenia)) {
			throw new ContraseniaVaciaException("La contraseÒa no puede estar vacÌa");
		}

		if (!this.correoValido(correo)) {
			throw new CorreoInvalidoException("El mail no es valido");
		}

		if (apellidos.contains("0") || apellidos.contains("1") || apellidos.contains("2") || apellidos.contains("3")
				|| apellidos.contains("4") || apellidos.contains("5") || apellidos.contains("6")
				|| apellidos.contains("7") || apellidos.contains("8") || apellidos.contains("9")) {
			throw new ApellidoInvalidoException("El nombre " + nombre + " no puede tener nÔøΩmeros");

		}
		Statement query = UtilsDB.conectarBD();

		if (query.executeUpdate("insert into usuario values('" + nombre + "','" + apellidos + "','" + correo + "','"
				+ contrasenia + "','" + fechaNacimiento + "','" + numeroHijos + "','" + direccion + "','" + nick
				+ "')") > 0) {
			System.out.println("Usuario inserado con exito");
			// Si la inserci√≥n en BD ha colado, ya podemos modificar las
			// Variables internas con la tranquilidad de que en BD
			// Tambi√©n existen.
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.numeroHijos = numeroHijos;
			this.fechaNacimiento = fechaNacimiento;
			this.contrasenia = contrasenia;
			this.direccion = direccion;
			this.correo = correo;
			this.nick = nick;
		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}

		UtilsDB.desconectarBD();

	}

	/**
	 * contruscto que se usa pra buusca si el usuario esiste
	 * 
	 * @param nick es el nick de dicho usuario
	 * @throws SQLException
	 */
	public Usuario(String nick) throws SQLException {
		super();

		Statement query = UtilsDB.conectarBD();
		ResultSet datosDevueltos = query.executeQuery("select * from usuario where nick='" + nick + "'");
		if (datosDevueltos.next()) {

			this.nombre = datosDevueltos.getString("nombre");
			this.apellidos = datosDevueltos.getString("apellidos");
			this.fechaNacimiento = datosDevueltos.getDate("fechaNacimiento").toLocalDate();
			this.contrasenia = datosDevueltos.getString("contrasenia");
			this.direccion = datosDevueltos.getString("direccion");
			this.correo = datosDevueltos.getString("correo");
			this.numeroHijos = datosDevueltos.getString("numehijos");
			this.nick = datosDevueltos.getString("nick");

		} else {
			throw new SQLException("El usuario no existe");
		}
	}

	/**
	 * constructor utilizado para comprar mediante los campos nick y contrsaeÒa si
	 * es o no el usuario
	 * 
	 * @param nick        nick de dicho usuario
	 * @param contrasenia contraseÒa de dicho usuario
	 * @throws ContraseniaIncorrectaException exepcion que salta si la contrseÒa no
	 *                                        existe
	 * @throws UsuarioNoExisteException       exepcion que salta si el usuari no
	 *                                        essite
	 * @throws SQLException                   exepcion q saÒltara si ahy algun
	 *                                        problema de base de datos
	 */
	public Usuario(String nick, String contrasenia)
			throws ContraseniaIncorrectaException, UsuarioNoExisteException, SQLException {
		super();

		Statement smt = UtilsDB.conectarBD();

		ResultSet cursor = smt.executeQuery("select * from usuario where nick='" + nick + "'");

		if (cursor.next()) {

			this.contrasenia = cursor.getString("contrasenia");

			if (!this.contrasenia.equals(contrasenia)) {

				UtilsDB.desconectarBD();

				throw new ContraseniaIncorrectaException("La contraseÒa no es correcta");

			}

			nombre = cursor.getString("nombre");
			this.apellidos = cursor.getString("apellidos");
			this.correo = cursor.getString("correo");
			this.contrasenia = cursor.getString("contrasenia");
			this.fechaNacimiento = cursor.getDate("fechaNacimiento").toLocalDate();
			this.contrasenia = cursor.getString("contrasenia");
			this.numeroHijos = cursor.getString("numerohijos");
			this.direccion = cursor.getString("direccion");
			this.nick = cursor.getString("nick");

		} else {

			UtilsDB.desconectarBD();

			throw new UsuarioNoExisteException("El usuario no existe");

		}

		UtilsDB.desconectarBD();
	}

	/**
	 * contructor vacio
	 */
	public Usuario() {
		super();
	}

	/**
	 * getter de apellido no alluda a moostrar el appelido
	 * 
	 * @return debuelve el valor
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * setter de apellido no alluda a la insersion del valor
	 * 
	 * @param apellidos es el valor
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * getter Facha nacimiento nos alluda a mostrar la fecha de nacimiento
	 * 
	 * @return no retorna el valor
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * setter de fecha de nacimiento nos alluda a dar valor
	 * 
	 * @param fechaNacimiento es el valor
	 * @throws SQLException esepcion que saltara si ese usuario no tie l afecha
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		if (smt.executeUpdate(
				"update usuario set fechaNacimiento='" + fechaNacimiento + "' where nick='" + nick + "'") > 0) {
			this.fechaNacimiento = fechaNacimiento;
		}
		UtilsDB.desconectarBD();

	}

	/**
	 * get contrasenia nois mostrara el valor de contrasenia
	 * 
	 * @returnretorna el valor
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * setter de contrasenia nos alluda a dar el valer a la variable
	 * 
	 * @param contrasenia es el valor
	 * @throws ContraseniaVaciaException
	 * @throws SQLException              saltara la exepcion si la contraseÒa esta
	 *                                   vacia
	 */
	public void setContrasenia(String contrasenia) throws ContraseniaVaciaException, SQLException {
		if (!this.contraseniaValida(contrasenia)) {
			throw new ContraseniaVaciaException("La contraseÒa no puede estar vacÌa");
		}
		Statement smt2 = UtilsDB.conectarBD();
		if (smt2.executeUpdate(
				"update usuario set contrasenia='" + contrasenia + "' where nick='" + this.nick + "'") > 0) {
			this.contrasenia = contrasenia;
		}
		UtilsDB.desconectarBD();

	}

	/**
	 * getter direccion nos alluda amostrar la contraseÒa
	 * 
	 * @return retorna el valor
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * setter de direccion nos alluda a dar valor a la variable
	 * 
	 * @param direccion es el valor
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;

	}

	/**
	 * getter de coreeo alluda a mostrar el valor
	 * 
	 * @return retorna el valor
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * setter de correo alluda a daar el valor
	 * 
	 * @param correo es el valor
	 * @throws CorreoInvalidoException es la exepcion q verifica el coreo
	 * @throws SQLException            comprueva en base de datos
	 */
	public void setCorreo(String correo) throws CorreoInvalidoException, SQLException {

		if (!this.correoValido(correo)) {
			throw new CorreoInvalidoException("El mail no es valido");
		}
		Statement smt1 = UtilsDB.conectarBD();

		if (smt1.executeUpdate("update usuario set correo='" + correo + "' where nick='" + this.nick + "'") > 0) {
			this.correo = correo;
		}
		UtilsDB.desconectarBD();

	}

	/**
	 * getter de numero de hijo muestra el valor
	 * 
	 * @return retorna el valor
	 */
	public String getNumehijos() {
		return numeroHijos;
	}

	/**
	 * setter de numero de hijo alluda a insertar el valor
	 * 
	 * @param numehijos es el valor
	 */
	public void setNumehijos(String numehijos) {

		this.numeroHijos = numehijos;

	}

	/**
	 * getter de nick alluda a mostrar el nick
	 * 
	 * @returnretorna el valor
	 */
	public String getNick() {

		return nick;
	}

	/**
	 * setter de nick alluda a dar valor
	 * 
	 * @param nick es el valor
	 * @throws SQLException
	 */
	public void setNick(String nick) throws SQLException {

		Statement smt = UtilsDB.conectarBD();
		if (smt.executeUpdate("update usuario set nick='" + nick + "' where nick='" + this.nick + "'") > 0) {
			this.nick = nick;
		}

		UtilsDB.desconectarBD();

	}

	/**
	 * funcion quer eliminara al usuari
	 * 
	 * @return retorna null
	 */
	public boolean eliminar() {
		Statement smt = UtilsDB.conectarBD();
		boolean ret;
		// El borrado lo hacemos con la PK para no equivocarnos y borrar lo que no es
		try {
			ret = smt.executeUpdate("delete from usuario where nombre='" + nombre + "'") > 0;
			// no nos queda m√°s remedio que borrar todas las variables internas
			// porque aqui el objeto no se puede poner a null, no tendr√≠a efecto en el main

			nombre = null;
			this.apellidos = null;
			this.fechaNacimiento = null;
			this.contrasenia = null;
			this.direccion = null;
			this.correo = null;
			this.numeroHijos = null;
			this.nick = null;

		} catch (SQLException e) {
			// e.printStackTrace();
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}

	/**
	 * aary de todos lo usuarios
	 * 
	 * @return retorna el valor
	 */
	public static ArrayList<Usuario> getTodos() {
		Statement smt = UtilsDB.conectarBD();
		// Inicializamos un ArrayList para devolver
		ArrayList<Usuario> ret = new ArrayList<Usuario>();

		try {

			ResultSet cursor = smt.executeQuery("select * from usuario");
			while (cursor.next()) {

				Usuario actual = new Usuario();

				actual.nombre = cursor.getString("nombre");
				actual.apellidos = cursor.getString("apellidos");
				actual.correo = cursor.getString("correo");
				actual.contrasenia = cursor.getString("contrasenia");
				actual.fechaNacimiento = cursor.getDate("fechaNacimiento").toLocalDate();
				actual.contrasenia = cursor.getString("contrasenia");
				actual.numeroHijos = cursor.getString("numeroHijos");
				actual.direccion = cursor.getNString("direccion");
				actual.nick = cursor.getString("nick");

				ret.add(actual);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		UtilsDB.desconectarBD();
		// Si no hay usuarios en la tabla, va a devolver un arraylist vac√≠o
		// Si la consulta fu√© erronea, se devuelve un ArrayList null, que son cosas
		// distintas
		return ret;
	}

	/**
	 * to estrin nos alluda a mostrar el usuario con los valores q tiene
	 */
	@Override
	public String toString() {
		return " " + nombre + " " + apellidos + ", con correo:" + correo + " con fechaNacimiento:" + fechaNacimiento
				+ " numeroHijos: " + numeroHijos + ", con direccion :" + direccion + ".";
	}

}
