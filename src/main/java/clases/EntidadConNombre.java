
package clases;

import exepciones.NombreInvalidoExceptions;

/**
 * Clase EntodadConnorbe la utilizimos apara q todas las clases eneden el nombre
 * 
 * @author AlexLopez
 *
 */
public class EntidadConNombre {

	protected String nombre;

	/**
	 * contructor q nos alluda a montar el nombre de todas las clases
	 * 
	 * @param nombre nuabo asignado
	 * @throws NombreInvalidoExceptions nos salta la exepcion si el nobre no es
	 *                                  valido
	 */
	public EntidadConNombre(String nombre) throws NombreInvalidoExceptions {
		if (nombre.contains("0") || nombre.contains("1") || nombre.contains("2") || nombre.contains("3")
				|| nombre.contains("4") || nombre.contains("5") || nombre.contains("6") || nombre.contains("7")
				|| nombre.contains("8") || nombre.contains("9")) {
			throw new NombreInvalidoExceptions("El nombre " + nombre + " no puede tener numeros");
		}
		this.nombre = nombre;
	}

	/**
	 * contructor basio para alludarnoa conruir la clase en nobre en donde queramos
	 * sin argumemtoso contructor general
	 */
	public EntidadConNombre() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * getter nombre SE encarga de mostrar EL VALOR
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * setter de nombre darle un valor al nombre
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	/**
	 * to estrin necesario para poser imprimir o visaliza el nobre
	 */
	public String toString() {
		return "EntidadConNombre [nombre=" + nombre + "]";
	}

}
