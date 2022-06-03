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
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import elementosVisuales.BotonAzul;
import elementosVisuales.BotonRojo;
import elementosVisuales.BotonVerde;
import exepciones.ContraseniaVaciaException;
import exepciones.CorreoInvalidoException;

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
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class PantallaUsuario extends JPanel {
	private Ventana ventana;
	private Ventana ventanaPrincipal;
	private JTextField txtNumber;
	private JLabel labelNombre;
	private JLabel labelCorreo;
	private JLabel labelApellidos;
	private JLabel  labelDireccion;
	private JLabel labelHijos;
	private JLabel labelNick;
	private JLabel labelContrasenia;
	
	private JTextField campoNombre;
	private JTextField campohijos;
	private JTextField campoApellidos;
	private JTextField campoTelefono;
	private JTextField textField_1;

	public PantallaUsuario(Ventana v) {
		setLayout(null);
		this.ventana=v;
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelNombre.setForeground(new Color(0, 0, 0));
		labelNombre.setBackground(new Color(255, 255, 255));
		labelNombre.setToolTipText("");
		labelNombre.setBounds(32, 139, 232, 33);
		add(labelNombre);
		
		campoNombre = new JTextField();
		campoNombre.setBackground(Color.WHITE);
		campoNombre.setBounds(370, 139, 105, 33);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		
		
		JLabel labelApellidos = new JLabel("Actividad Desempeñada:");
		labelApellidos.setToolTipText("");
		labelApellidos.setForeground(new Color(0, 0, 0));
		labelApellidos.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelApellidos.setBackground(new Color(255, 255, 255));
		labelApellidos.setBounds(32, 176, 286, 33);
		add(labelApellidos);
		
		campoApellidos = new JTextField();
		campoApellidos.setBounds(370, 181, 172, 33);
		add(campoApellidos);
		campoApellidos.setColumns(10);
		
		JLabel labelTelefono;
		labelTelefono = new JLabel("Telefono:");
		labelTelefono.setToolTipText("");
		labelTelefono.setForeground(new Color(0, 0, 0));
		labelTelefono.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelTelefono.setBackground(new Color(255, 255, 255));
		labelTelefono.setBounds(32, 220, 232, 33);
		add(labelTelefono);
		
		campoTelefono = new JTextField();
		campoTelefono.setColumns(10);
		campoTelefono.setBounds(370, 225, 147, 33);
		add(campoTelefono);
		
		JButton botonCancelar = new BotonRojo("Cancelar");
		botonCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.cambiarPantalla("principal");
			}
		});
		botonCancelar.setBackground(new Color(255, 0, 0));
		botonCancelar.setFont(new Font("Dialog", Font.PLAIN, 26));
		botonCancelar.setForeground(Color.BLACK);
		botonCancelar.setToolTipText("Cancelar");
		botonCancelar.setBounds(399, 397, 224, 37);
		add(botonCancelar);
		
		BotonVerde botonAceptar = new BotonVerde("Aceptar");
		
		botonAceptar.setToolTipText("Aceptar");
		botonAceptar.setForeground(Color.BLACK);
		botonAceptar.setFont(new Font("Dialog", Font.PLAIN, 26));
		botonAceptar.setBounds(32, 399, 224, 37);
		add(botonAceptar);
		
		JLabel labelTrabajador = new JLabel("Trabajador");
		labelTrabajador.setFont(new Font("Tahoma", Font.BOLD, 29));
		labelTrabajador.setBounds(307, 27, 172, 44);
		add(labelTrabajador);
		
		

		
		JLabel Fondo = new JLabel("");
		Fondo.setBounds(-23, 11, 891, 499);;
		Fondo.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\Ventana_UsusarioAPI.jpg"));
		add(Fondo);
		
	
		
	
		
		
		
		botonAceptar.addMouseListener(new MouseAdapter() {
		
			
			
			
		});
		
		
		
		
		
		


		
		
		
		
	
		
		
		
	
	
		
		
		
	
		
		
		
		


}
}


