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
 * 
 * @author AlexLopez
 *
 */
public class Prestamo extends Gastos {
	float porcentajeInteres;
	private LocalDate fechaFin;

	/**
	 * 
	 * @param nombre            del nuevo prestamo
	 * @param importeFijo       nos indica con un boleano si es fijo o no
	 * @param importe           importe del nuevo prestamo
	 * @param fecha             nos indiva la fecha del pretamo q es sera un fue
	 * @param porcentajeInteres no indica el porcentaje de interes del prestamo
	 * @param fechaFin          no indicara la fecha de fin del prestamo
	 * @param codigoMovimiento  nos indica el codigo movimiento del prestamo
	 * @throws SQLException             saltara dicha exepcion si ahy algun problema
	 *                                  trelacionado con base de datos
	 * @throws NombreInvalidoExceptions nos salta la exepcion si el nobre no es
	 *                                  valido
	 **/
	public Prestamo(String nombre, boolean importeFijo, float importe, LocalDate fecha, float porcentajeInteres,
			LocalDate fechaFin, int codigoMovimiento) throws SQLException, NombreInvalidoExceptions {
		super(nombre, importeFijo, importe, fecha, codigoMovimiento);

		Statement query = UtilsDB.conectarBD();
		if (query.executeUpdate("insert into Prestamo values('" + nombre + "'," + importeFijo + "," + importe + ",'"
				+ fecha + "'," + porcentajeInteres + ",'" + fechaFin + "'," + codigoMovimiento + ")") > 0) {
			System.out.println("Prestamo inserada con exito");

			this.nombre = nombre;
			this.importeFijo = importeFijo;
			this.importe = importe;
			this.fecha = fecha;
			this.porcentajeInteres = porcentajeInteres;
			this.fechaFin = fechaFin;
			this.codigoMovimiento = codigoMovimiento;

		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}

	}

	Prestamo() {
		/**
		 * cobtructor vacio para poder contruir en cualquier clase con cualquier valor
		 */
	}

	@SuppressWarnings("null")

	/**
	 * funvion utilizada para eliminar un pretamo
	 * 
	 * @return nosrfetornara todos los valores en NUll
	 */
	public boolean eliminarPrestamo() {
		Statement smt = UtilsDB.conectarBD();
		boolean ret;

		try {
			ret = smt.executeUpdate("delete from Prestamo where nombre='" + nombre + "'") > 0;

			this.nombre = null;
			this.importeFijo = null != null;
			this.importe = 0;
			this.fecha = null;
			this.porcentajeInteres = 0;
			this.fechaFin = null;
			this.codigoMovimiento = 0;

		} catch (SQLException e) {
			// e.printStackTrace();
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}

	/**
	 * array list de pretamos
	 * 
	 * @return nos ira devolviendo tdod los prestamos que estan en base de datos
	 */
	public static ArrayList<Prestamo> getTodosprestamo() {
		Statement smt = UtilsDB.conectarBD();
//Inicializamos un ArrayList para devolver
		ArrayList<Prestamo> ret = new ArrayList<Prestamo>();

		try {

			ResultSet cursor = smt.executeQuery("select * from Prestamo");
			while (cursor.next()) {

				Prestamo actual = new Prestamo();

				actual.nombre = cursor.getString("nombre");
				actual.importeFijo = cursor.getBoolean("importeFijo");
				actual.importe = cursor.getFloat("importe");
				actual.fecha = cursor.getDate("fecha").toLocalDate();
				actual.porcentajeInteres = cursor.getFloat("porcentaje");
				actual.fechaFin = cursor.getDate("fecha").toLocalDate();
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
	 * funcion que no escrive un informe de los pretams en un archivo txt
	 * 
	 * @throws IOException nos inda si ahy algun problema con la base de datos
	 */
	public static void imprimeInforme() throws IOException {
		File archivo = new File("./Informes/InformeCompras.txt");
		if (archivo.exists()) {
			archivo.delete();
		}
		archivo.createNewFile();
		FileWriter escritor = new FileWriter(archivo, true);
		ArrayList<Prestamo> informe = getTodosprestamo();

		for (int i = 0; i < informe.size(); i++) {
			escritor.write(" -- ");
			;
			escritor.write("Nombre. " + informe.get(i).getNombre());
			escritor.write(" Importe. " + informe.get(i).getImporte());
			escritor.write("Porcentaje." + informe.get(i).getPorcentajeInteres());
			escritor.write("Es Fijo. " + informe.get(i).isImporteFijo() + "\n");

		}
		escritor.flush();
		escritor.close();
	}

	/**
	 * getters de porcentaje interes muestra el valor del inters
	 * 
	 * @return devuelve el valor
	 */
	public Float getPorcentajeInteres() {
		return porcentajeInteres;
	}

	/**
	 * setter de porcentaje da valor a la variable
	 * 
	 * @param porcentajeInteres es el valor de la variable
	 */
	public void setPorcentajeInteres(Float porcentajeInteres) {
		this.porcentajeInteres = porcentajeInteres;
	}

	/**
	 * getrer de Fecha fin nos mustra el valor de la FechaFin
	 * 
	 * @return devuelve el valor
	 */
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	/**
	 * setter da el valor a la variable
	 * 
	 * @param fechaFin es el valor de la variable
	 */
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

}
