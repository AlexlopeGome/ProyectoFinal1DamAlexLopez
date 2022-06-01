package clases;

public class EntidadConNombre {

	protected static String nombre;



	public EntidadConNombre(String nombre) {
		super();
		EntidadConNombre.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		EntidadConNombre.nombre = nombre;
	}

	@Override
	public String toString() {
		return "EntidadConNombre [nombre=" + nombre + "]";
	}

}
