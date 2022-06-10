
package clases;

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
	 */
	public EntidadConNombre(String nombre) {

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
