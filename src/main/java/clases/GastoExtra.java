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
import exepciones.NombreInvalidoExceptions;

/**
 * Clase a controlar los gastos extra
 * 
 * @author AlexLopez
 *
 */
public class GastoExtra extends Gastos {

	/**
	 * 
	 * @param nombre           de nuevo gasto extra
	 * @param importeFijo      no indica con un bolleano si es fijo o no
	 * @param importe          importe de dicho gasto
	 * @param fecha            fecha dek gasto que sera que es y q fue
	 * @param codigoMovimiento codigo de mimiento gasto extra nuebo
	 * @throws SQLException             controlo la exeocion de insersion de base
	 *                                  detos por si falla
	 * @throws NombreInvalidoExceptions nos salta la exepcion si el nobre no es
	 *                                  valido
	 */
	public GastoExtra(String nombre, boolean importeFijo, float importe, LocalDate fecha, int codigoMovimiento)
			throws SQLException, NombreInvalidoExceptions {
		super(nombre, importeFijo, importe, fecha, codigoMovimiento);
		// TODO Auto-generated constructor stub

		Statement query = UtilsDB.conectarBD();

		if (query.executeUpdate(

				"insert into GastoExtra values('" + nombre + "'," + importeFijo + "," + importe + ",'" + fecha + "',"
						+ codigoMovimiento + ")") > 0) {
			System.out.println("Gasto extra  inserado con exito");

			this.nombre = nombre;
			this.importeFijo = importeFijo;
			this.importe = importe;
			this.fecha = fecha;
			this.codigoMovimiento = codigoMovimiento;

		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		UtilsDB.desconectarBD();

	}

	/**
	 * contructor vacio pra alludar nos a mosnta un gasyto como nos interese
	 */
	public GastoExtra() {
		super();

	}

	/**
	 * contructor para buscar el gasto
	 * 
	 * @param fecha del gasto actual
	 * @throws SQLException controla la exepcion de la busqueda
	 */
	public GastoExtra(LocalDate fecha) throws SQLException {
		super();

		Statement query = UtilsDB.conectarBD();
		ResultSet datosDevueltos = query.executeQuery("select * from compra where fecha='" + fecha + "'");
		if (datosDevueltos.next()) {

			nombre = datosDevueltos.getString("nombre");
			importeFijo = datosDevueltos.getBoolean("importeFijo");
			importe = datosDevueltos.getFloat("importe");
			fecha = datosDevueltos.getDate("fecha").toLocalDate();
			codigoMovimiento = datosDevueltos.getInt(codigoMovimiento);

		} else {
			throw new SQLException("la compra no existe");
		}

	}

	@SuppressWarnings("null")
	/**
	 * funcion q usaremos pra eliminar un Gasto Extra
	 * 
	 * @return retorna el valor de tdo en null
	 */
	public boolean eliminarGastoExtra() {
		Statement smt = UtilsDB.conectarBD();
		boolean ret;

		try {
			ret = smt.executeUpdate("delete from GastoExtra where nombre='" + nombre + "'") > 0;

			nombre = null;
			this.importeFijo = null != null;
			this.importe = 0;
			this.fecha = null;

		} catch (SQLException e) {
			// e.printStackTrace();
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}

	/**
	 * array lista de tos los gastos
	 * 
	 * @return retorna todos los gasto exixtentes en BD
	 */
	public static ArrayList<GastoExtra> getTodosGastosExtra() {
		Statement smt = UtilsDB.conectarBD();
		// Inicializamos un ArrayList para devolver
		ArrayList<GastoExtra> ret = new ArrayList<GastoExtra>();

		try {

			ResultSet cursor = smt.executeQuery("select * from GastoExtra");
			while (cursor.next()) {

				GastoExtra actual = new GastoExtra();

				actual.nombre = cursor.getString("nombre");
				actual.importeFijo = cursor.getBoolean("importeFijo");
				actual.importe = cursor.getFloat("importe");
				actual.fecha = cursor.getDate("fecha").toLocalDate();
				actual.codigoMovimiento = cursor.getInt("codigoMovimiento");

				ret.add(actual);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		UtilsDB.desconectarBD();

		return ret;

	}

	/**
	 * funcion q nos escrive un archibo txt con el informe de tos los gastos
	 * 
	 * @throws IOException
	 */
	public static void imprimeInforme() throws IOException {
		File archivo = new File("./Informes/InformeGastosExtra.txt");
		if (archivo.exists()) {
			archivo.delete();
		}
		archivo.createNewFile();
		FileWriter escritor = new FileWriter(archivo, true);
		ArrayList<GastoExtra> informe = getTodosGastosExtra();

		for (int i = 0; i < informe.size(); i++) {
			escritor.write(" -- ");
			;
			escritor.write("Nombre. " + informe.get(i).getNombre());
			escritor.write(" Importe. " + informe.get(i).getImporte() + "\n");

		}
		escritor.flush();
		escritor.close();
	}

}
