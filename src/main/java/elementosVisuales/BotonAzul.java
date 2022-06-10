package elementosVisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Clase BotonAzul   da las carecteristicas es pecificas a el boton
 * @author AlexLopez
 *
 */
public class BotonAzul extends BotonVerde {
	
	public BotonAzul(String m) {
		super(m);
		estiloPorDefectoAzul();
		addMouseListener(new MouseAdapter() {
	

	public void mouseEntered(MouseEvent e) {
		setBackground(new Color(240,255,240));
		setFont(new Font("Rockwell",Font.BOLD, 18));
		
	}
	
	public void mouseExited(MouseEvent e) {
		estiloPorDefectoAzul();
	}
	});
}

/*
 * Da estilos por defecto al BotonAzul
 */
private void estiloPorDefectoAzul() {
this.setForeground(new Color(0, 0, 0));
this.setBackground(Color.BLUE);
this.setFont(new Font("Rockwell", Font.PLAIN, 14));
this.setCursor(new Cursor (Cursor.HAND_CURSOR)); //A�ADIDO A MANO, PONE LA MANO EN VEZ DE LA FLECHA
}

}