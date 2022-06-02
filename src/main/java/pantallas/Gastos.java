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

public class Gastos extends JPanel {
	;
	private Ventana ventana;
	private final JLabel label = new JLabel("");

	public Gastos(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton btnNewButton = new BotonRojo("Compra");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.cambiarPantalla("compra");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(266, 306, 121, 33);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new BotonRojo("Extraescolar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(522, 306, 149, 33);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new BotonRojo("Prestamo");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(522, 161, 117, 33);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new BotonRojo("Otros Gastos");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("compra");
			}
		});
		btnNewButton_3.setBounds(266, 161, 149, 33);
		add(btnNewButton_3);
		
		JButton botonAtras = new BotonAzul("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.cambiarPantalla("queHacer");
				
			}
			
		
		});
		botonAtras.setBounds(412, 46, 89, 23);
		add(botonAtras);
		
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
		botonSalir.setBounds(0, 376, 99, 32);
		add(botonSalir);
		
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\VentanaGastos_de_casa_API.jpg"));
		fondo.setBounds(-23, 11, 891, 499);
		add(fondo);
		
	;
		
		
		
		
		
		
	
		
		
	
		
		
		


		
	
		
	

		

}
}


