package exepciones;
/**
 * exepcion para el usuario invalido
 * @author AlexLopez
 *
 */
public class UsuarioNoExisteException extends Exception {
	public UsuarioNoExisteException (String msg) {
		super(msg);
	}
}
