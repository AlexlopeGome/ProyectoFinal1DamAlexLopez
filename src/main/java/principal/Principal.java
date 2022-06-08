package principal;

import java.sql.SQLException;

import clases.Usuario;
import exepciones.ContraseniaIncorrectaException;
import exepciones.UsuarioNoExisteException;
import pantallas.PantallaLogin;
import pantallas.Ventana;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana ventana=new Ventana();

		System.out.println("Longitud de args: "+args.length);
		String nick=(args[0]);
		String contrasenia =(args[1]);
		
		System.out.println(nick+contrasenia);
		
	try {
		Usuario usuario = new Usuario(nick,contrasenia);
	} catch (ContraseniaIncorrectaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UsuarioNoExisteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}


}
