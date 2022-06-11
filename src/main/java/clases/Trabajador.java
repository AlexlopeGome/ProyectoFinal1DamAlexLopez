package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Utils.UtilsDB;
import enums.TipoActividadDesenpeniada;
import exepciones.NombreInvalidoExceptions;

/**
 * 
 * @author AlexLopez
 *
 */
public class Trabajador extends EntidadConNombre {

	private int telefono;
	private String activi;
	private TipoActividadDesenpeniada actividadDesempeniada;

	/**
	 * 
	 * @param nombre   nobre del nuebo trabajador
	 * @param telefono telefono del nuebo trabajador
	 * @param activi   avtividad q desempeÒa
	 * @throws SQLException             exencion pora los fallos de base de datos
	 * @throws NombreInvalidoExceptions nos salta la exepcion si el nobre no es
	 *                                  valido
	 */
	public Trabajador(String nombre, int telefono, TipoActividadDesenpeniada activi)
			throws SQLException, NombreInvalidoExceptions {
		super(nombre);
		this.telefono = telefono;
		this.actividadDesempeniada = actividadDesempeniada;

		Statement query = UtilsDB.conectarBD();

		if (query.executeUpdate(
				"insert into Trabajador values('" + nombre + "','" + activi + "'," + telefono + ")") > 0) {
			System.out.println("Trabajador inserado con exito");
			// Si la inserci√≥n en BD ha colado, ya podemos modificar las
			// Variables internas con la tranquilidad de que en BD
			// Tambi√©n existen.
			this.nombre = nombre;
			this.telefono = telefono;
			this.actividadDesempeniada = actividadDesempeniada;
			;
		} else {
			throw new SQLException("No se ha podido insertar el Trabajador");

		}

		UtilsDB.desconectarBD();

	}

	/**
	 * contructor para buscar el trabajador
	 * 
	 * @param telefono es el telefono q tiene
	 * @throws SQLException nos da cualquyier erro con base de datos
	 */
	public Trabajador(int telefono) throws SQLException {
		super();
		this.telefono = telefono;

		Statement query = UtilsDB.conectarBD();
		ResultSet datosDevueltos = query.executeQuery("select * from Trabajador where fecha=" + telefono + "");
		if (datosDevueltos.next()) {

			nombre = datosDevueltos.getString("nombre");
			telefono = datosDevueltos.getInt("telefono");
			activi = datosDevueltos.getString("actividadDesempeÒada");

		} else {
			throw new SQLException("el trabajador no existe");
		}

	}

	/**
	 * contructor vacio
	 */
	public Trabajador() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * getter telefono no alluda a motrar el telefono
	 * 
	 * @return nos retorna el valor
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * setter de telefomo nos alluda a dart el valor
	 * 
	 * @param telefono es el valor
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * getter de TipoactividadDeesempeniada nos mustra el valor
	 * 
	 * @return nos retorna el valor
	 */
	public TipoActividadDesenpeniada getActividadDesempeÒada() {
		return actividadDesempeniada;
	}

	/**
	 * setter de actividad nos alluda a dar el valor
	 * 
	 * @param actividadDesempeniada es el valor
	 */
	public void setActividadDesempeÒada(TipoActividadDesenpeniada actividadDesempeÒada) {
		this.actividadDesempeniada = actividadDesempeÒada;
	}

	/**
	 * getter activi nos alluda a mostrar el valor
	 * 
	 * @return nos retorna el valor
	 */

	public String getActivi() {
		return activi;
	}

	/**
	 * setter de activi no alluda a dar el valo
	 * 
	 * @param activi es el valor
	 */

	public void setActivi(String activi) {
		this.activi = activi;
	}

	/**
	 * Funcion que elimina el Trabajador
	 * 
	 * @return retorna el valor en null
	 */

	@SuppressWarnings("null")
	public boolean eliminarTrabajador() {
		Statement smt = UtilsDB.conectarBD();
		boolean ret;

		try {
			ret = smt.executeUpdate("delete  from Trabajador where nombre='" + nombre + "'") > 0;

			this.nombre = null;
			this.telefono = 0;
			this.activi = null;

		} catch (SQLException e) {
			// e.printStackTrace();
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}

	/**
	 * array q nos da los valores en base de datos
	 * 
	 * @returnretorna el ararry
	 */
	public static ArrayList<Trabajador> getTodostrabajdores() {
		Statement smt = UtilsDB.conectarBD();
//Inicializamos un ArrayList para devolver
		ArrayList<Trabajador> ret = new ArrayList<Trabajador>();

		try {

			ResultSet cursor = smt.executeQuery("select * from Trabajador");
			while (cursor.next()) {

				Trabajador actual = new Trabajador();

				actual.nombre = cursor.getString("nombre");
				actual.telefono = cursor.getInt("telefono");
				actual.activi = cursor.getString("actividadDesempeÒada");

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

}
