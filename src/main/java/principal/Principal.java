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
/**
 * este es el main princimal del programa 
 * @param args son los argumetos pasados 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/**
 * Map cotrresponde a el mapa que guardara los agrgumento los cuales se introduciran atraves del 
 * bucle 
 */
		Map<Integer, String> argumentos = new HashMap<>();
		for (int i = 0; i < args.length; i++) {
			argumentos.put(i, args[i]);

			System.out.println("Pasado por argumentos: " + argumentos.get(i));
		}

		if (!argumentos.isEmpty() && argumentos.size() >= 2) {
			try {
				
				/**
				 * este es el usuario que lleva los argumetos de programa 
				 */
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


	}

}
