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
		setLayout(null);
		
		
	 JButton btnbotonVerde = new BotonVerde("");
	 btnbotonVerde.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
	 		
	 	}
	 });
		btnbotonVerde.addMouseListener(new MouseAdapter() {
			
			
		});
		add(btnbotonVerde);
		label.setBounds(544, 17, 0, 0);
		add(label);
		label.setVerticalAlignment(SwingConstants.TOP);
		JLabel lblIniciarSesion = new JLabel("Bienvenido");
		lblIniciarSesion.setForeground(Color.WHITE);
		lblIniciarSesion.setBounds(260, 17, 215, 37);
		lblIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(lblIniciarSesion);
		
		JButton botonSalir = new BotonRojo("Salir");
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
		botonSalir.setBounds(260, 284, 224, 37);
		add(botonSalir);
		
		BotonVerde botonInicioSesion = new BotonVerde("Iniciar Sesion");
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
		botonInicioSesion.setBounds(260, 223, 224, 37);
		add(botonInicioSesion);
		
		
		JButton botonRegistro = new BotonAzul("Registro");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("usuario");
			}
		});
		botonRegistro.setBackground(new Color(0, 0, 255));
		botonRegistro.setForeground(new Color(0, 0, 0));
		botonRegistro.setFont(new Font("Dialog", Font.PLAIN, 26));
		botonRegistro.setBounds(260, 166, 224, 37);
		add(botonRegistro);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\General_VentanasApi.jpg"));
		lblNewLabel.setBounds(0, -18, 670, 440);
		add(lblNewLabel);
		
		
		
		
	
		
		
		
		


}
}


