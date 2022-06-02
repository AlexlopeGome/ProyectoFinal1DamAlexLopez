package clases;

public class EntidadConNombre {

protected String nombre;

	public EntidadConNombre(String nombre) {
		
		this.nombre = nombre;
	}

	public EntidadConNombre() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "EntidadConNombre [nombre=" + nombre + "]";
	}

}
