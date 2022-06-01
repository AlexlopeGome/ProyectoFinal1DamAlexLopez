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
import elementosVisuales.BotonRojo;
import elementosVisuales.BotonVerde;
import exepciones.ContraseniaIncorrectaException;
import exepciones.UsuarioNoExisteException;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class QueHacer extends JPanel {
	;
	private Ventana ventana;
	private final JLabel label = new JLabel("");

	public QueHacer(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("¿Que Hacemos?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(236, 21, 213, 50);
		add(lblNewLabel);
		
		JButton botonIngresos = new BotonVerde("Ingresos");
		botonIngresos.setFont(new Font("Dialog", Font.PLAIN, 20));
		botonIngresos.setBounds(275, 317, 114, 37);
		add(botonIngresos);
		
		JButton BotonEditar = new BotonAzul("editarPerfil");
		BotonEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("editar");
			}
		});
		BotonEditar.setFont(new Font("Dialog", Font.PLAIN, 20));
		BotonEditar.setBounds(422, 317, 138, 37);
		add(BotonEditar);
		
		
		JButton BotonGastos = new BotonRojo("Gastos");
		BotonGastos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.cambiarPantalla("gastos");
			}
			
		});
		BotonGastos.setFont(new Font("Dialog", Font.PLAIN, 20));
		BotonGastos.setBounds(115, 317, 114, 37);
		add(BotonGastos);
		
		
		JButton BotonAtras = new JButton("Atras");
		BotonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("principal");
			}
		});
		BotonAtras.setFont(new Font("Tahoma", Font.PLAIN, 18));
		BotonAtras.setBackground(Color.YELLOW);
		BotonAtras.setForeground(Color.BLACK);
		BotonAtras.setBounds(74, 119, 104, 37);
		add(BotonAtras);
		
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
		botonSalir.setBounds(548, 30, 85, 37);
		add(botonSalir);
		
		
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\Ventana_UsusarioAPI.jpg"));
		Fondo.setBounds(0, 0, 658, 439);
		add(Fondo);
		
	
		
		
	
		
		
		


		
	
		
	

		

}
}


