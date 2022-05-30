package pantallas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import jdk.internal.org.jline.terminal.Cursor;

public class Ventana extends JFrame{
	
	
	
public Ventana() {
	this.setSize(790, 450);
    this.setLocationRelativeTo(null);//Te pone la ventana en el centro
this.setIconImage(new ImageIcon("./iconos/miLogo.png").getImage());

this.setTitle("Proyecto pruebas de Interfaces 1");
    //this.setAlwaysOnTop(true);
    //this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    //this.setExtendedState(JFrame.MAXIMIZED_BOTH);//Esta y
    //this.setUndecorated(true); // esta hace que este en pantalla completa siempre qye setVisible este debajo del todo.
    this.setContentPane(new PantallaInicio(this));

    this.setResizable(false);//No deja cambiar el tamaño si esta en false.
    this.setVisible(true);
    //this.setBounds(100, 300, 800, 500);

}

}



