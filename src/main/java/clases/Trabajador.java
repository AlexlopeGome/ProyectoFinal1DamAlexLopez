package clases;

public class Trabajador extends EntidadConNombre {
	
private String claseTrabajador;	
	
public Trabajador(String nombre, String claseTrabajador) {
		super(nombre);
		this.claseTrabajador = claseTrabajador;
	}



public String getClaseTrabajador() {
	return claseTrabajador;
}

public void setClaseTrabajador(String claseTrabajador) {
	this.claseTrabajador = claseTrabajador;
}

@Override
public String toString() {
	return "Trabajador [claseTrabajador=" + claseTrabajador + "]";
}
}
