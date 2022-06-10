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
import exepciones.NombreInvalidoExceptions;

/**
 * clase Extraescolar :para creaar un gasto de tipo extraescolar
 * 
 * @author AlexLopez
 *
 */
public class ExtraEscolar extends Gastos {
	private Clases clase;
	private String claseC;
	private DiasSemana diasSemana;

	private String diasSemanaD;
	private String nombreProfesor;

	/**
	 * Contructor con todos los campos que persiste la la extraexcolar creada
	 * 
	 * @param nombre           de la nueba extraescolar
	 * @param importeFijo      no indica si es fijo con un boolen
	 * @param importe          es el importe de la actividafd exatrescolar
	 * @param fecha            en la que se arrila de actividad o se realizara
	 * @param nombreProfesor   profesor q importa la clase dicho nobre sera el mismo
	 *                         de que aparece ene el campo nobre de la clase
	 *                         trabajacdor
	 * @param claseC           se refiere al tipo de activa q se realiza
	 * @param diasSemanaD      hace rederencia al nombre del enum
	 * @param codigoMovimiento es el codigo q llavara esta nueba actividad
	 * @throws SQLException salta si ahy algun problema con la base de datos
	 * @throws NombreInvalidoExceptions nos salta la exepcion si el nobre no es valido
	 */
	public ExtraEscolar(String nombre, boolean importeFijo, float importe, LocalDate fecha, String nombreProfesor,
			Clases claseC, DiasSemana diasSemanaD, int codigoMovimiento) throws SQLException, NombreInvalidoExceptions {
		super(nombre, importeFijo, importe, fecha, codigoMovimiento);

		Statement query = UtilsDB.conectarBD();
		if (query.executeUpdate(
				"insert into extraEscolar values('" + nombre + "'," + importeFijo + "," + importe + ",'" + fecha + "','"
						+ nombreProfesor + "','" + claseC + "','" + diasSemanaD + "'," + codigoMovimiento + ")") > 0) {
			System.out.println("Actividad extraescolar inserada con exito");

			this.nombre = nombre;
			this.importeFijo = importeFijo;
			this.importe = importe;
			this.fecha = fecha;
			this.nombreProfesor = nombreProfesor;
			this.clase = clase;
			this.diasSemana = diasSemana;
			this.codigoMovimiento = codigoMovimiento;

		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}

		UtilsDB.desconectarBD();
	}

	/**
	 * contrctuctor q usaremos para poder cerar un objeto bacio como queramos
	 */
	public ExtraEscolar() {
	}

	/**
	 * contructor la usaremos ara combro si esiset la actividad extraescolar
	 * 
	 * @param nombre es el nobre de la actividad
	 * @throws SQLException no dara una exepcion si no esta la compra
	 */
	public ExtraEscolar(String nombre) throws SQLException {
		super();
		this.clase = clase;

		Statement query = UtilsDB.conectarBD();
		ResultSet datosDevueltos = query.executeQuery("select * from extraEscolar where nombre='" + nombre + "'");
		if (datosDevueltos.next()) {

			nombre = datosDevueltos.getString("nombre");
			importeFijo = datosDevueltos.getBoolean("importeFijo");
			importe = datosDevueltos.getFloat("importe");
			fecha = datosDevueltos.getDate("fecha").toLocalDate();
			nombreProfesor = datosDevueltos.getString("nombreProfesor");
			claseC = datosDevueltos.getString("asignaturas");
			diasSemanaD = datosDevueltos.getString("diasSemana");
			codigoMovimiento = datosDevueltos.getInt(codigoMovimiento);

		} else {
			throw new SQLException("la compra no existe");
		}

	}

	/**
	 * Funcion q no elilina la actividda
	 * 
	 * @retur nos debuelve el ret de la compra eliminada
	 */
	public boolean eliminarExtraEscolar() {
		Statement smt = UtilsDB.conectarBD();
		boolean ret;

		try {
			ret = smt.executeUpdate("delete from extraEscolar where nombre='" + nombre + "'") > 0;

			this.nombre = null;
			this.importeFijo = false;
			this.importe = 0;
			this.fecha = null;
			this.nombreProfesor = null;
			this.clase = null;
			this.diasSemana = null;
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
	 * ArrayList getTodosEXtraescolar
	 * 
	 * @return nos intera en base datos y nos debuelve todas las cobras en la
	 *         columna EXtraescolar metiendolas en el array
	 */
	public static ArrayList<ExtraEscolar> getTodosExtraEscolar() {
		Statement smt = UtilsDB.conectarBD();

		ArrayList<ExtraEscolar> ret = new ArrayList<ExtraEscolar>();

		try {

			ResultSet cursor = smt.executeQuery("select * from extraescolar");
			while (cursor.next()) {

				ExtraEscolar actual = new ExtraEscolar();

				actual.nombre = cursor.getString("nombre");
				actual.importeFijo = cursor.getBoolean("importeFijo");
				actual.importe = cursor.getFloat("importe");
				actual.nombreProfesor = cursor.getString("nombreProfesor");
				actual.fecha = cursor.getDate("fecha").toLocalDate();
				actual.fecha = cursor.getDate("fecha").toLocalDate();

				actual.claseC = cursor.getString("asignaturas");
				actual.diasSemanaD = cursor.getString("diaSemana");

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
	 * esta funcion imprimeImforme la utilizamos para crear un fichero con dicho
	 * nombre de todas las extraescolares realizadas
	 * 
	 * @throws IOException
	 */
	public static void imprimeInforme() throws IOException {
		File archivo = new File("./Informes/InformeExtraescolar.txt");
		if (archivo.exists()) {
			archivo.delete();
		}
		archivo.createNewFile();
		FileWriter escritor = new FileWriter(archivo, true);
		ArrayList<ExtraEscolar> informe = getTodosExtraEscolar();

		for (int i = 0; i < informe.size(); i++) {
			escritor.write(" -- ");
			;
			escritor.write("Nombre. " + informe.get(i).getNombre());
			escritor.write(" Importe. " + informe.get(i).getImporte());
			escritor.write(" Tipo Clase. " + informe.get(i).getClaseC());
			escritor.write("Dias de la Semana. " + informe.get(i).getDiasSemanaD());
			escritor.write("Profesor. " + informe.get(i).getNombreProfesor() + "\n");
		}
		escritor.flush();
		escritor.close();
	}

	/**
	 * getter claseC SE encarga de mostrar EL VALOR
	 * 
	 * @return lo devuelve
	 */
	public String getClaseC() {
		return claseC;
	}

	/**
	 * setters claseC se encarga de darle un valor
	 * 
	 * @param claseC es la variable
	 */
	public void setClaseC(String claseC) {
		this.claseC = claseC;
	}

	/**
	 * getter DiasSemanaD SE encarga de mostrar EL VALOR
	 * 
	 * @returnlo devuelve
	 */
	public String getDiasSemanaD() {
		return diasSemanaD;
	}

	/**
	 * setters DiasSemanaD se encarga de darle un valor
	 * 
	 * @param diasSemanaD es la variable
	 */
	public void setDiasSemanaD(String diasSemanaD) {
		this.diasSemanaD = diasSemanaD;
	}

	/**
	 * getter clase SE encarga de mostrar EL VALOR
	 * 
	 * @return lo devuelve
	 */
	public Clases getClase() {
		return clase;
	}

	/**
	 * setter Clase se encarga de darle un valor
	 * 
	 * @param clase variable
	 */
	public void setClase(Clases clase) {
		this.clase = clase;
	}

	/**
	 * getter DiasSEmana SE encarga de mostrar EL VALOR
	 * 
	 * @return lo devuelve
	 */
	public DiasSemana getDiasSemana() {
		return diasSemana;
	}

	/**
	 * setter diasSeman se encarga de darle un valor
	 * 
	 * @param diasSemana es la variable
	 */
	public void setDiasSemana(DiasSemana diasSemana) {
		this.diasSemana = diasSemana;
	}

	/**
	 * getter NombreProfesor SE encarga de mostrar EL VALOR
	 * 
	 * @return lo devuelve
	 */
	public String getNombreProfesor() {
		return nombreProfesor;
	}

	/**
	 * settter de darle un valor nombreProfseor
	 * 
	 * @param nombreProfesor variable
	 */
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

}
