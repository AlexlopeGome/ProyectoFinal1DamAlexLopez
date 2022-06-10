package pantallas;


import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import elementosVisuales.BotonAzul;
import elementosVisuales.BotonRojo;
import elementosVisuales.BotonVerde;

import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaPrincipal extends JPanel {
	
	private Ventana ventanaPrincipal;
	private final JLabel label = new JLabel("");
	private JTextField txtNumber;
	private Ventana ventana;

	public PantallaPrincipal(Ventana v) {
		this.ventana=v;
		setToolTipText("");
		setBorder(new EmptyBorder(1, 1, 1, 1));
		setBackground(Color.WHITE);
		
		
	 JButton btnbotonVerde = new BotonVerde("");
	 btnbotonVerde.setBounds(0, 0, 0, 0);
	 btnbotonVerde.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
	 		
	 	}
	 });
		btnbotonVerde.addMouseListener(new MouseAdapter() {
			
			
		});
		setLayout(null);
		add(btnbotonVerde);
		label.setBounds(544, 17, 0, 0);
		add(label);
		label.setVerticalAlignment(SwingConstants.TOP);
		JLabel lblIniciarSesion = new JLabel("Bienvenido");
		lblIniciarSesion.setBounds(293, 17, 215, 37);
		lblIniciarSesion.setForeground(Color.WHITE);
		lblIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(lblIniciarSesion);
		
		JButton botonSalir = new BotonRojo("Salir");
		botonSalir.setBounds(270, 308, 224, 37);
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(ABORT);
			}
		});
		botonSalir.setBackground(new Color(255, 0, 0));
		botonSalir.setFont(new Font("Dialog", Font.PLAIN, 26));
		botonSalir.setText("Salir");
		botonSalir.setForeground(Color.BLACK);
		botonSalir.setToolTipText("Salir");
		add(botonSalir);
		
		BotonVerde botonInicioSesion = new BotonVerde("Iniciar Sesion");
		botonInicioSesion.setBounds(270, 260, 224, 37);
		botonInicioSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("login");
			}
		});
		botonInicioSesion.setToolTipText("Iniciar Sesion");
		botonInicioSesion.setText("Iniciar Sesion");
		botonInicioSesion.setForeground(Color.BLACK);
		botonInicioSesion.setFont(new Font("Dialog", Font.PLAIN, 26));
		add(botonInicioSesion);
		
		
		JButton botonRegistroUsuario = new BotonAzul("Registro");
		botonRegistroUsuario.setText("Registro Usuario");
		botonRegistroUsuario.setBounds(248, 156, 277, 37);
		botonRegistroUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("usuario");
			}
		});
		botonRegistroUsuario.setBackground(new Color(0, 0, 255));
		botonRegistroUsuario.setForeground(new Color(0, 0, 0));
		botonRegistroUsuario.setFont(new Font("Dialog", Font.PLAIN, 26));
		add(botonRegistroUsuario);
		
		BotonAzul botonRegistroUsuario_1 = new BotonAzul("Registro");
		botonRegistroUsuario_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("trabajador");
			}
		});
		botonRegistroUsuario_1.setText("Registro Trabajador");
		botonRegistroUsuario_1.setForeground(Color.BLACK);
		botonRegistroUsuario_1.setFont(new Font("Dialog", Font.PLAIN, 26));
		botonRegistroUsuario_1.setBackground(Color.BLUE);
		botonRegistroUsuario_1.setBounds(248, 204, 277, 37);
		add(botonRegistroUsuario_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-23, 11, 891, 499);
		lblNewLabel.setIcon(new ImageIcon("./fondos/General_VentanasApi.jpg"));
		add(lblNewLabel);
		
		

		
		
		
		
	
		
		
		
		


}
}


