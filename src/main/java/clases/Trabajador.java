package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;

import Utils.UtilsDB;
import enums.TipoActividadDesenpeniada;

/**
 * 
 * @author AlexLopez
 *
 */
public class Trabajador extends EntidadConNombre {

	private int telefono;
	private String activi;
	private TipoActividadDesenpeniada actividadDesempe�ada;

	/**
	 * 
	 * @param nombre
	 * @param telefono
	 * @param activi
	 * @throws SQLException
	 */
	public Trabajador(String nombre, int telefono, TipoActividadDesenpeniada activi) throws SQLException {
		super(nombre);
		this.telefono = telefono;
		this.actividadDesempe�ada = actividadDesempe�ada;

		Statement query = UtilsDB.conectarBD();

		if (query.executeUpdate(
				"insert into Trabajador values('" + nombre + "','" + activi + "'," + telefono + ")") > 0) {
			System.out.println("Trabajador inserado con exito");
			// Si la inserción en BD ha colado, ya podemos modificar las
			// Variables internas con la tranquilidad de que en BD
			// También existen.
			this.nombre = nombre;
			this.telefono = telefono;
			this.actividadDesempe�ada = actividadDesempe�ada;
			;
		} else {
			throw new SQLException("No se ha podido insertar el Trabajador");

		}

		UtilsDB.desconectarBD();

	}

	/**
	 * 
	 * @param telefono
	 * @throws SQLException
	 */
	public Trabajador(int telefono) throws SQLException {
		super();
		this.telefono = telefono;

		Statement query = UtilsDB.conectarBD();
		ResultSet datosDevueltos = query.executeQuery("select * from Trabajador where fecha=" + telefono + "");
		if (datosDevueltos.next()) {

			nombre = datosDevueltos.getString("nombre");
			telefono = datosDevueltos.getInt("telefono");
			activi = datosDevueltos.getString("actividadDesempe�ada");

		} else {
			throw new SQLException("el trabajador no existe");
		}

	}

	/**
	 * 
	 */
	public Trabajador() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * 
	 * @param telefono
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * 
	 * @return
	 */
	public TipoActividadDesenpeniada getActividadDesempe�ada() {
		return actividadDesempe�ada;
	}

	/**
	 * 
	 * @param actividadDesempe�ada
	 */
	public void setActividadDesempe�ada(TipoActividadDesenpeniada actividadDesempe�ada) {
		this.actividadDesempe�ada = actividadDesempe�ada;
	}

	/**
	 * 
	 * @return
	 */

	public String getActivi() {
		return activi;
	}

	/**
	 * 
	 * @param activi
	 */

	public void setActivi(String activi) {
		this.activi = activi;
	}

	/**
	 * 
	 * @return
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
	 * 
	 * @return
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
				actual.activi = cursor.getString("actividadDesempe�ada");

				ret.add(actual);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		UtilsDB.desconectarBD();
		// Si no hay usuarios en la tabla, va a devolver un arraylist vacío
		// Si la consulta fué erronea, se devuelve un ArrayList null, que son cosas
		// distintas
		return ret;

	}

}
