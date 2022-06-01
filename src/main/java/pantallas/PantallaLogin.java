package pantallas;


import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.EmptyBorder;

import clases.Usuario;
import elementosVisuales.BotonAzul;
import elementosVisuales.BotonVerde;
import exepciones.ContraseniaIncorrectaException;
import exepciones.UsuarioNoExisteException;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PantallaLogin extends JPanel {
	;
	private Ventana ventana;
	private JTextField campoNick;
	private final JLabel label = new JLabel("");
	private JPasswordField campoContraseña;

	public PantallaLogin(Ventana v) {
		this.ventana=v;
		setToolTipText("");
		setBorder(new EmptyBorder(1, 1, 1, 1));
		setBackground(Color.WHITE);
		setLayout(null);
		
		final JLabel Nick = new JLabel(" Nick:");
		Nick.setToolTipText("");
		Nick.setBounds(106, 181, 95, 31);
		Nick.setForeground(Color.WHITE);
		Nick.setFont(new Font("Tahoma", Font.BOLD, 18));
		Nick.setVerticalAlignment(SwingConstants.TOP);
		Nick.setBackground(Color.WHITE);

		add(Nick);
		
		campoNick = new JTextField();
		campoNick.setBounds(206, 177, 108, 30);
		campoNick.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(campoNick);
		campoNick.setColumns(10);
		
		JLabel Contrasenia = new JLabel("Contraseña");
		Contrasenia.setBounds(383, 178, 136, 29);
		Contrasenia.setForeground(Color.WHITE);
		Contrasenia.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(Contrasenia);
		
		campoContraseña = new JPasswordField();
		campoContraseña.setToolTipText("");
		campoContraseña.setBounds(518, 177, 110, 31);
		add(campoContraseña);
	
		label.setVerticalAlignment(SwingConstants.TOP);
		JLabel lblIniciarSesion = new JLabel("Iniciar Sesion");
		lblIniciarSesion.setForeground(Color.BLUE);
		lblIniciarSesion.setBounds(263, 17, 207, 37);
		lblIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(lblIniciarSesion);
		
		JButton botonLogin = new BotonVerde("Aceptar");
		botonLogin.addMouseListener(new MouseAdapter() {
	
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nick= campoNick.getText();
					String contrasenia = new String (campoContraseña.getPassword());
					ventana.PantayaloginV2= new Usuario(nick,contrasenia);
					JOptionPane.showMessageDialog(ventana, "Bienvenido, "+ventana.PantayaloginV2, "Login correcto", JOptionPane.PLAIN_MESSAGE);
					ventana.cambiarPantalla("queHacer");
					System.out.println(nick);
					System.out.println(contrasenia);
				
							new Usuario(nick,contrasenia );
						} catch (SQLException e1) {
							System.out.println(e1);
						} catch (ContraseniaIncorrectaException e1) {
							JOptionPane.showMessageDialog(ventana,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
							
						} catch (UsuarioNoExisteException e1) {
												
													}

						}
		});
		
		
		botonLogin.setForeground(Color.BLACK);
		botonLogin.setToolTipText("Login");
		botonLogin.setBounds(301, 263, 136, 34);
		add(botonLogin);
		
		JButton botonAtras = new BotonAzul("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("principal");
			}
		});
		botonAtras.setBackground(new Color(0, 0, 255));
		botonAtras.setFont(new Font("Dialog", Font.PLAIN, 14));
		botonAtras.setBounds(301, 318, 136, 31);
		add(botonAtras);
		
		JLabel fondo = new JLabel("New label");
		fondo.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\Ventana_UsusarioAPI.jpg"));
		fondo.setBounds(0, 11, 723, 438);
		add(fondo);
		

		
	
		
	
		
	
		


}
}


