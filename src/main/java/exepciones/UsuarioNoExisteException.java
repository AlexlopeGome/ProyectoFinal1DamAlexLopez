package exepciones;

public class UsuarioNoExisteException extends Exception {
	public UsuarioNoExisteException (String msg) {
		super(msg);
	}
}
