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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class PantallaUsuario extends JPanel {
	
	private Ventana ventanaPrincipal;
	private JTextField txtNumber;
	private JLabel labelCorreo;
	private JTextField campoNombre;
	private JTextField campoNick;
	private JTextField campohijos;
	private JTextField campoDireccion;
	private JTextField campoFechaNacimiento;
	private JTextField campoCorreo;
	private JTextField campoApellidos;
	private JPasswordField compoContrasenia;

	public PantallaUsuario(Ventana v) {
		setLayout(null);
		
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNombre.setForeground(Color.WHITE);
		labelNombre.setBackground(Color.WHITE);
		labelNombre.setToolTipText("");
		labelNombre.setBounds(151, 66, 90, 33);
		add(labelNombre);
		
		campoNick = new JTextField();
		campoNick.setBackground(Color.WHITE);
		campoNick.setBounds(499, 313, 86, 20);
		add(campoNick);
		campoNick.setColumns(10);
		
		JLabel labelApellidos = new JLabel("Apellidos:");
		labelApellidos.setToolTipText("");
		labelApellidos.setForeground(Color.WHITE);
		labelApellidos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelApellidos.setBackground(Color.WHITE);
		labelApellidos.setBounds(151, 103, 90, 33);
		add(labelApellidos);
		
		campohijos = new JTextField();
		campohijos.setBackground(Color.WHITE);
		campohijos.setBounds(499, 282, 86, 20);
		add(campohijos);
		campohijos.setColumns(10);
		
		
		JLabel labelCorreo;
		labelCorreo = new JLabel("Correo:");
		labelCorreo.setToolTipText("");
		labelCorreo.setForeground(Color.WHITE);
		labelCorreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCorreo.setBackground(Color.WHITE);
		labelCorreo.setBounds(151, 147, 90, 33);
		add(labelCorreo);
		
		
		campoDireccion = new JTextField();
		campoDireccion.setBackground(Color.WHITE);
		campoDireccion.setBounds(499, 245, 86, 20);
		add(campoDireccion);
		campoDireccion.setColumns(10);
		
		JLabel labelFechaNacimento = new JLabel("Fecha Nacimento:");
		labelFechaNacimento.setToolTipText("");
		labelFechaNacimento.setForeground(Color.WHITE);
		labelFechaNacimento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelFechaNacimento.setBackground(Color.WHITE);
		labelFechaNacimento.setBounds(151, 187, 166, 33);
		add(labelFechaNacimento);
		
		campoFechaNacimiento = new JTextField();
		campoFechaNacimiento.setBackground(Color.WHITE);
		campoFechaNacimiento.setBounds(499, 201, 86, 20);
		add(campoFechaNacimiento);
		campoFechaNacimiento.setColumns(10);
		
		
		JLabel labelDireccion = new JLabel("Direccion:");
		labelDireccion.setToolTipText("");
		labelDireccion.setForeground(Color.WHITE);
		labelDireccion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelDireccion.setBackground(Color.WHITE);
		labelDireccion.setBounds(151, 231, 166, 33);
		add(labelDireccion);
		
		campoCorreo = new JTextField();
		campoCorreo.setBackground(Color.WHITE);
		campoCorreo.setBounds(499, 161, 86, 20);
		add(campoCorreo);
		campoCorreo.setColumns(10);
		
		
		JLabel labelHijos = new JLabel("Hijos:");
		labelHijos.setToolTipText("");
		labelHijos.setForeground(Color.WHITE);
		labelHijos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelHijos.setBackground(Color.WHITE);
		labelHijos.setBounds(151, 263, 90, 33);
		add(labelHijos);
		
		campoApellidos = new JTextField();
		campoApellidos.setBackground(Color.WHITE);
		campoApellidos.setBounds(499, 117, 86, 20);
		add(campoApellidos);
		campoApellidos.setColumns(10);
		
		JLabel labelNick = new JLabel("Nick:");
		labelNick.setToolTipText("");
		labelNick.setForeground(Color.WHITE);
		labelNick.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNick.setBackground(Color.WHITE);
		labelNick.setBounds(151, 299, 90, 33);
		add(labelNick);
		
		campoNombre = new JTextField();
		campoNombre.setBackground(Color.WHITE);
		campoNombre.setBounds(499, 80, 86, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel labelContrasenia = new JLabel("Contrase\u00F1a");
		labelContrasenia.setToolTipText("");
		labelContrasenia.setForeground(Color.WHITE);
		labelContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelContrasenia.setBackground(Color.WHITE);
		labelContrasenia.setBounds(151, 339, 166, 33);
		add(labelContrasenia);
		
		compoContrasenia = new JPasswordField();
		compoContrasenia.setBackground(Color.WHITE);
		compoContrasenia.setBounds(493, 344, 92, 20);
		add(compoContrasenia);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, -16, 654, 483);
		lblNewLabel.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\Ventana_UsusarioAPI.jpg"));
		add(lblNewLabel);
		
		
		
		
		


		
		
		
		
	
		
		
		
	
	
		
		
		
	
		
		
		
		


}
}


