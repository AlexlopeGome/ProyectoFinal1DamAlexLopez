package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import Utils.UtilsDB;

public class Gastos extends Movimiento  {

	public Gastos(String nombre, boolean importeFijo, float importe, LocalDate fecha, int codigoMovimiento) {
		super(nombre, importeFijo, importe, fecha, codigoMovimiento);
		// TODO Auto-generated constructor stub
	}

	public Gastos () {
		
	}


	
}
