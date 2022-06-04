package clases;

public class Trabajador extends EntidadConNombre {

private int telefono;
private String claseTrabajador;	
	
public Trabajador(String nombre,int telefono, String claseTrabajador) {
		super(nombre);
		this.claseTrabajador = claseTrabajador;
		
		
		
		
		
	}



public int getTelefeno() {
	return telefono;
}



public void setTelefeno(int telefeno) {
	this.telefono = telefeno;
}



public String getClaseTrabajador() {
	return claseTrabajador;
}

public void setClaseTrabajador(String claseTrabajador) {
	this.claseTrabajador = claseTrabajador;
}



@Override
public String toString() {
	return "Trabajador [telefeno=" + telefono + ", claseTrabajador=" + claseTrabajador + "]";
}



}
