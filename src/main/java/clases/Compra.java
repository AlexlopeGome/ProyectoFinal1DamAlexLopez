package clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Compra extends Gastos {
	
private ArrayList tipoCompra;
private String comentario;	
	
public Compra(String nombre, boolean importeFijo, float importe, LocalDate fecha, ArrayList tipoCompra,
			String comentario) {
		super(nombre, importeFijo, importe, fecha);
		this.tipoCompra = tipoCompra;
		this.comentario = comentario;
	}

public ArrayList getTipoCompra() {
	return tipoCompra;
}
public void setTipoCompra(ArrayList tipoCompra) {
	this.tipoCompra = tipoCompra;
}
public String getComentario() {
	return comentario;
}
public void setComentario(String comentario) {
	this.comentario = comentario;
}
@Override
public String toString() {
	return "Compra [tipoCompra=" + tipoCompra + ", comentario=" + comentario + "]";
}
}
