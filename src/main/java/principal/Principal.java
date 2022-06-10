package principal;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import clases.Usuario;
import exepciones.ContraseniaIncorrectaException;
import exepciones.UsuarioNoExisteException;
import pantallas.Ventana;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, String> argumentos = new HashMap<>();
		for (int i = 0; i < args.length; i++) {
			argumentos.put(i, args[i]);

			System.out.println("Pasado por argumentos: " + argumentos.get(i));
		}

		if (!argumentos.isEmpty() && argumentos.size() >= 2) {
			try {
				Usuario master = new Usuario(argumentos.get(0), argumentos.get(1));
				new Ventana(master);
			} catch (ContraseniaIncorrectaException |UsuarioNoExisteException |SQLException e)  {
				
				System.err.println( e.getMessage());
				Ventana ventana = new Ventana();
				JOptionPane.showMessageDialog(ventana, e.getMessage(), "Login Incorrecto", JOptionPane.PLAIN_MESSAGE);
				 
			}
		}else {
			new Ventana();
		}

		//Ventana ventana = new Ventana();
	}

}
