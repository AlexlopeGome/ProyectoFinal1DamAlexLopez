package pantallas;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Usuario;
import elementosVisuales.ElementoListaUsuarios;

public class Ventana extends JFrame{
	//private HashMap<String, JPanel> pantallas;
	private JPanel pantallaActual;
	protected Object PantayaloginV2 ;


	public Ventana() {

		
		this.setSize(700,550);  
		this.setLocationRelativeTo(null); 
		
		this.setIconImage(new ImageIcon("./icono/cenec.png").getImage());
		this.setTitle("Home Manager");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		this.pantallaActual=new PantallaInicio(this);
		this.setContentPane(pantallaActual);
	
        this.setResizable(false);
        this.setVisible(true);
  

    }
    public  void cambiarPantalla(String nombrePantalla) {
        this.pantallaActual.setVisible(false);
        this.pantallaActual=null;
        switch(nombrePantalla){

        case "inicio":
            this.pantallaActual=new PantallaInicio(this);
            break;
        case "principal":
            this.pantallaActual=new PantallaPrincipal(this);
            break;
        case"usuario":
            this.pantallaActual=new PantallaUsuario(this);
            break;
            
        case "editar":
        	this.pantallaActual=new ListaUsuarios(this);
            break;
            
        case "login":
        	this.pantallaActual=new PantallaLogin(this);
            break;    
        
        
    	case "queHacer":
    	this.pantallaActual=new QueHacer(this);
        break;    
    	
        
    	case "gastos":
    	this.pantallaActual=new Gastos(this);
        break;    
    	}
        this.pantallaActual.setVisible(true);
        this.setContentPane(pantallaActual);
    }
}



