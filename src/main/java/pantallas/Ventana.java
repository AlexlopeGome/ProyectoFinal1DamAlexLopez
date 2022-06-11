package pantallas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import clases.Usuario;

/**
 * Esta ventana intacia a la ventana en si esesta ventana se le hacen llegar
 * llos argumnetos
 * 
 * @author AlexLopez
 *
 */
public class Ventana extends JFrame {

	private JPanel pantallaActual;
	protected Object PantayaloginV2;
	protected Usuario usuario;

	/**
	 * contructor generico de la ventana
	 */
	public Ventana() {
		this.pantallaActual = new PantallaInicio(this);
		this.setContentPane(pantallaActual);
		inicioPantallaPrincipal();
	}

	/**
	 * este contructor se usa para generan la vemtana con sus parametrso
	 * 
	 * @param master es la clave y usuario procendente de la clase principal
	 */
	public Ventana(Usuario master) {
		this.usuario = master;
		this.pantallaActual = new PantallaInicio(this);
		this.setContentPane(pantallaActual);

		inicioPantallaPrincipal();
	}

	private void inicioPantallaPrincipal() {
		this.setSize(800, 550);
		this.setLocationRelativeTo(null);

		this.setIconImage(new ImageIcon("./icono/cenec.png").getImage());
		this.setTitle("Home Manager");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setResizable(false);
		this.setVisible(true);
	}

	/**
	 * Esta funcion se utiliza para cambiar la ventanas
	 * 
	 * @param nombrePantalla este es el parametro q indicara en cada casa el nombre
	 *                       de la pantallav
	 */
	public void cambiarPantalla(String nombrePantalla) {
		if (this.pantallaActual != null) {
			this.pantallaActual.setVisible(false);
		} else {
			this.pantallaActual = null;
		}

		switch (nombrePantalla) {

		case "inicio":
			this.pantallaActual = new PantallaInicio(this);
			break;
		case "Principal":
			this.pantallaActual = new PantallaPrincipal(this);
			break;
		case "usuario":
			this.pantallaActual = new PantallaUsuario(this);
			break;
		case "trabajador":
			this.pantallaActual = new PantallaTrabajador(this);
			break;

		case "editar":
			this.pantallaActual = new ListaUsuarios(this);
			break;

		case "listaTrabajadores":
			this.pantallaActual = new ListaTrabajadores(this);
			break;
		case "listaCompras":
			this.pantallaActual = new PantallaListaCompras(this);
			break;
		case "listaIngresos":
			this.pantallaActual = new PantallaListaIngresos(this);
			break;
		case "listaExtra":
			this.pantallaActual = new PantallaListaGastosExtra(this);
			break;

		case "listaExtraEscolar":
			this.pantallaActual = new PantallaListaExtraEscolar(this);
			break;

		case "listaServicio":
			this.pantallaActual = new PantallaListaServicio(this);
			break;
		case "listaPrestamo":
			this.pantallaActual = new PantallaListaPrestamo(this);
			break;

		case "login":
			this.pantallaActual = new PantallaLogin(this);
			break;

		case "queHacer":
			this.pantallaActual = new QueHacer(this);
			break;
		case "ingresos":
			this.pantallaActual = new PantallaIngreso(this);
			break;

		case "gastos":
			this.pantallaActual = new PantallaGastos(this);
			break;

		case "gastoEx":
			this.pantallaActual = new PantallaGastoExtra(this);
			break;

		case "compra":
			this.pantallaActual = new PantallaCompra(this);
			break;

		case "extraExcolar":
			this.pantallaActual = new PantallaExtraescolar(this);
			break;
		case "servicio":
			this.pantallaActual = new PantallaServicio(this);
			break;

		case "prestamo":
			this.pantallaActual = new PantallaPrestamo(this);
			break;

		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}
}
