package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import Utils.UtilsDB;
import enums.TipoCompra;
import exepciones.ContraseniaVaciaException;

/**
 * Clase para crea una nueba Compra
 * 
 * @author AlexLopez
 *
 */
public class Compra extends Gastos {
	/*
	 * Correcponde un enum de tipo de compras
	 */
	private TipoCompra tipo;
	/*
	 * variable creada para guardar el tipo de compra
	 */
	private String tipoC;
	/*
	 * Comtentaria de la compra
	 */
	private String comentario;

	LocalDate fechaAhora = LocalDate.now();

	/**
	 * Constructor con todos los campos que persiste la compra creada
	 * 
	 * @param nombre           de la compra a crear
	 * @param importeFijo      nos indica si la compra es fija debolviendono un
	 *                         boolean
	 * @param importe          nos indica el importe d la compra a crear
	 * @param fecha            nos indica la fecha ene la q se relizara la compra o
	 *                         esta prevista realizar la compra creada
	 * @param comentario       una breve comtentario de como ta ah ido la compra
	 * @param tipoC            es el string debuelto del enum elegido en la compra
	 *                         creada
	 * @param codigoMovimiento nel el codido de la compra creada ( no se puede
	 *                         repetir dicho codigo en dicha compra
	 * @throws SQLException nos salta la exepcion si ahy algun problema con
	 *                      insersion base de datos
	 */

	public Compra(String nombre, boolean importeFijo, float importe, LocalDate fecha, String comentario,
			TipoCompra tipoC, int codigoMovimiento) throws SQLException {
		super(nombre, importeFijo, importe, fecha, codigoMovimiento);
		this.comentario = comentario;

		Statement query = UtilsDB.conectarBD();

		if (query.executeUpdate(

				"insert into compra values('" + nombre + "'," + importeFijo + "," + importe + ",'" + fecha + "','"
						+ comentario + "','" + tipoC + "'," + codigoMovimiento + ")") > 0) {
			System.out.println("Compra inserada con exito");

			// Si la inserción en BD ha colado, ya podemos modificar las
			// Variables internas con la tranquilidad de que en BD
			// También existen.
			this.nombre = nombre;
			this.importeFijo = importeFijo;
			this.importe = importe;
			this.fecha = fecha;
			this.comentario = comentario;
			this.tipo = tipo;
			this.codigoMovimiento = codigoMovimiento;

		} else {
			throw new SQLException("No se ha podido insertar la Compra");
		}
		UtilsDB.desconectarBD();

	}

	/**
	 * getter TipoC SE encarga de mostrar EL VALOR
	 * 
	 * @return debuelbe el tipoC
	 */
	public String getTipoC() {
		return tipoC;
	}

	/**
	 * setter de tipoC de darle un valor tipo de La compra
	 * 
	 * @param tipoC ES EL VALOR Q TENDRA
	 */
	public void setTipoC(String tipoC) {
		this.tipoC = tipoC;
	}

	/**
	 * clase generica comra para allidar a contruir mas compras
	 */
	public Compra() {

	}

	/*
	 * contructor con la fecha para comprobar si esis dicha fecha a la busqueda de
	 * una combra
	 * 
	 */
	public Compra(LocalDate fecha) throws SQLException {

		Statement query = UtilsDB.conectarBD();
		ResultSet datosDevueltos = query.executeQuery("select * from compra where fecha='" + fecha + "'");
		if (datosDevueltos.next()) {

			nombre = datosDevueltos.getString("nombre");
			importeFijo = datosDevueltos.getBoolean("importeFijo");
			importe = datosDevueltos.getFloat("importe");
			importe = datosDevueltos.getFloat("importe");
			tipoC = datosDevueltos.getString("tipoCompra");
			comentario = datosDevueltos.getString("comentario");
			codigoMovimiento = datosDevueltos.getInt("codigoMovimiento");

		} else {
			throw new SQLException("la compra no existe");
		}

	}

	/**
	 * getTipo encarga de mostrar EL VALOR
	 * 
	 * @return debuelbe el enun
	 */
	public TipoCompra getTipo() {
		return tipo;
	}

	/**
	 * setter del tipo de darle un valor tipo de La compra
	 * 
	 * @param tipo nombre del enunm
	 */
	public void setTipo(TipoCompra tipo) {
		this.tipo = tipo;
	}

	/**
	 * getter comentario encarga de mostrar EL VALOR
	 * 
	 * @return debuel en cometario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * setter cometario
	 * 
	 * @param comentario de la compra
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@SuppressWarnings("null")
	/**
	 * funcion que elimima la compra
	 * 
	 * @return dos debuelve el ret de la compra eliminada con lo que todos los
	 *         balore pasaran a ser nulos
	 */
	public boolean eliminarCompra() {
		Statement smt = UtilsDB.conectarBD();
		boolean ret;

		try {
			ret = smt.executeUpdate("delete from compra where nombre='" + nombre + "'") > 0;

			nombre = null;
			this.importeFijo = null != null;
			this.importe = 0;
			this.fecha = null;
			this.tipoC = null;
			this.comentario = null;
			this.codigoMovimiento = (Integer) null;

		} catch (SQLException e) {
			// e.printStackTrace();
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}

	/**
	 * ArrayList getTodasCompras
	 * 
	 * @return nos intera en base datos y nos debuelve todas las cobras en la
	 *         columna compra metiendolas en el array
	 */
	public static ArrayList<Compra> getTodasCompras() {
		Statement smt = UtilsDB.conectarBD();
//Inicializamos un ArrayList para devolver
		ArrayList<Compra> ret = new ArrayList<Compra>();

		try {

			ResultSet cursor = smt.executeQuery("select * from compra");

			while (cursor.next()) {

				Compra actual = new Compra();

				actual.nombre = cursor.getString("nombre");
				actual.importeFijo = cursor.getBoolean("importeFijo");
				actual.importe = cursor.getFloat("importe");
				actual.fecha = cursor.getDate("fecha").toLocalDate();
				actual.tipoC = cursor.getString("tipoCompras");
				actual.comentario = cursor.getString("comentario");
				actual.codigoMovimiento = cursor.getInt("codigoMovimiento");

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

	/**
	 * esta funcion imprimeImforme la utilizamos para crear un fichero con dicho
	 * nombre de toas las compras realizadas
	 * 
	 * @throws IOException
	 */
	public static void imprimeInforme() throws IOException {
		File archivo = new File("./Informes/InformeCompras.txt");
		if (archivo.exists()) {
			archivo.delete();
		}
		archivo.createNewFile();
		FileWriter escritor = new FileWriter(archivo, true);
		ArrayList<Compra> informe = getTodasCompras();

		for (int i = 0; i < informe.size(); i++) {
			escritor.write(" -- ");
			;
			escritor.write("Nombre. " + informe.get(i).getNombre());
			escritor.write(" Importe. " + informe.get(i).getImporte());
			escritor.write(" Tipo Compra. " + informe.get(i).getTipoC());
			escritor.write("Es Fijo. " + informe.get(i).isImporteFijo());
			escritor.write("Cometario. " + informe.get(i).getComentario() + "\n");
		}
		escritor.flush();
		escritor.close();
	}

}
