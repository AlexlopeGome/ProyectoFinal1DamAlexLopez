package elementosVisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

/**
 * clase BotonVerde la da al boton estas caracteristicas
 * 
 * @author AlexLopez
 *
 */
public class BotonVerde extends JButton {

	public BotonVerde(String m) {
		super(m);
		estiloPorDefecto();

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(240, 255, 240));
				setFont(new Font("Rockwell", Font.BOLD, 18));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				estiloPorDefecto();

			}
		});
	}

	/**
	 * funcion q le da los estilos por defecto
	 */
	private void estiloPorDefecto() {

		this.setForeground(new Color(0, 0, 0));
		this.setBackground(new Color(0, 255, 0));
		this.setFont(new Font("Rockwell", Font.PLAIN, 14));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR)); // A�ADIDO A MANO, PONE LA MANO EN VEZ DE LA FLECHA

	}

}
