package clases;

public class Trabajador extends EntidadConNombre {

private int telefeno;
private String claseTrabajador;	
	
public Trabajador(String nombre,int telefono, String claseTrabajador) {
		super(nombre);
		this.claseTrabajador = claseTrabajador;
	}



public int getTelefeno() {
	return telefeno;
}



public void setTelefeno(int telefeno) {
	this.telefeno = telefeno;
}



public String getClaseTrabajador() {
	return claseTrabajador;
}

public void setClaseTrabajador(String claseTrabajador) {
	this.claseTrabajador = claseTrabajador;
}



@Override
public String toString() {
	return "Trabajador [telefeno=" + telefeno + ", claseTrabajador=" + claseTrabajador + "]";
}



}
