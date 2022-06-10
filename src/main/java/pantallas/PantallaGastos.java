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
/**
 * Esta pantalla recoge todos los botonos de los tipos Gastos
 * 
 * @author AlexLopez
 *
 */
public class PantallaGastos extends JPanel {
	;
	private Ventana ventana;
	private final JLabel label = new JLabel("");

	public PantallaGastos(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton botonCompra = new BotonRojo("Compra");
		botonCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.cambiarPantalla("compra");
			}
		});
		botonCompra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonCompra.setBounds(266, 306, 121, 33);
		add(botonCompra);
		
		JButton botonExtraescolar = new BotonRojo("Extraescolar");
		botonExtraescolar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("extraExcolar");
			}
		});
		botonExtraescolar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonExtraescolar.setBounds(522, 306, 149, 33);
		add(botonExtraescolar);
		
		JButton botonPrestamo = new BotonRojo("Prestamo");
		botonPrestamo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("prestamo");
			}
		});
		botonPrestamo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonPrestamo.setBounds(522, 161, 129, 33);
		add(botonPrestamo);
		
		JButton botonOtrosGastos = new BotonRojo("Otros Gastos");
		botonOtrosGastos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonOtrosGastos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("gastoEx");
			}
		});
		botonOtrosGastos.setBounds(266, 161, 149, 33);
		add(botonOtrosGastos);
		
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
		
		BotonRojo BotonServicio = new BotonRojo("Servicio");
		BotonServicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("servicio");
				
			}
		});
		BotonServicio.setText("Servicio");
		BotonServicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BotonServicio.setBounds(388, 389, 149, 33);
		add(BotonServicio);
		
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("./fondos/VentanaGastos_de_casa_API.jpg"));
		fondo.setBounds(-23, 11, 891, 499);
		add(fondo);
		
	
		
	;
		
		
		
		
		
		
	
		
		
	
		
		
		


		
	
		
	

		

}
}


