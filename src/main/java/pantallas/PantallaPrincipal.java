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

	public PantallaPrincipal(Ventana v) {
		setToolTipText("");
		setBorder(new EmptyBorder(1, 1, 1, 1));
		setBackground(Color.WHITE);
		setLayout(null);
		
		
	 JButton btnbotonVerde = new BotonVerde("Vamos....");
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
		
		JButton btnbtnbotonVerde = new BotonRojo("Salir");
		btnbtnbotonVerde.setBackground(new Color(255, 0, 0));
		btnbtnbotonVerde.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnbtnbotonVerde.setText("Salir");
		btnbtnbotonVerde.setForeground(Color.BLACK);
		btnbtnbotonVerde.setToolTipText("Salir");
		btnbtnbotonVerde.setBounds(260, 284, 224, 37);
		add(btnbtnbotonVerde);
		
		BotonVerde botonInicioSesion = new BotonVerde("Iniciar Sesion");
		botonInicioSesion.setToolTipText("Iniciar Sesion");
		botonInicioSesion.setText("Iniciar Sesion");
		botonInicioSesion.setForeground(Color.BLACK);
		botonInicioSesion.setFont(new Font("Dialog", Font.PLAIN, 26));
		botonInicioSesion.setBounds(260, 214, 224, 37);
		add(botonInicioSesion);
		
		BotonVerde botonRegistro = new BotonVerde("Registro");
		botonRegistro.setBackground(Color.BLUE);
		botonRegistro.setToolTipText("Registro");
		botonRegistro.setText("Registro");
		botonRegistro.setForeground(Color.BLACK);
		botonRegistro.setFont(new Font("Dialog", Font.PLAIN, 26));
		botonRegistro.setBounds(260, 152, 224, 37);
		add(botonRegistro);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\General_VentanasApi.jpg"));
		lblNewLabel.setBounds(0, -18, 670, 440);
		add(lblNewLabel);
		
		
		
	
		
		
		
		


}
}


