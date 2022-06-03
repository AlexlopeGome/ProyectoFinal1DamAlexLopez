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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.TipoActividadDesenpeniada;

public class PantallaTrabajador extends JPanel {
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
	private JTextField campoTelefono;

	public PantallaTrabajador(Ventana v) {
		setLayout(null);
		this.ventana=v;
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelNombre.setForeground(new Color(0, 0, 0));
		labelNombre.setBackground(Color.WHITE);
		labelNombre.setToolTipText("");
		labelNombre.setBounds(104, 156, 232, 33);
		add(labelNombre);
		
		campoNombre = new JTextField();
		campoNombre.setBackground(Color.WHITE);
		campoNombre.setBounds(452, 160, 105, 33);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		
		
		JLabel Telefono = new JLabel("Telefono:");
		Telefono.setToolTipText("");
		Telefono.setForeground(new Color(0, 0, 0));
		Telefono.setFont(new Font("Tahoma", Font.BOLD, 23));
		Telefono.setBackground(Color.WHITE);
		Telefono.setBounds(104, 193, 232, 33);
		add(Telefono);
		
		campoTelefono = new JTextField();
		campoTelefono.setBounds(452, 197, 105, 33);
		add(campoTelefono);
		campoTelefono.setColumns(10);
		
	
		
		JLabel labelTipoActividadDesenpeniada  = new JLabel("Tipo Actividad Desenpe\u00F1ada ");
		labelTipoActividadDesenpeniada.setToolTipText("");
		labelTipoActividadDesenpeniada.setForeground(new Color(0, 0, 0));
		labelTipoActividadDesenpeniada.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelTipoActividadDesenpeniada.setBackground(Color.WHITE);
		labelTipoActividadDesenpeniada.setBounds(42, 236, 333, 33);
		add(labelTipoActividadDesenpeniada);
		
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
		labelTrabajador.setBounds(295, 27, 167, 31);
		add(labelTrabajador);;
		
		JComboBox comboBoxTipoTrabajador = new JComboBox();
		comboBoxTipoTrabajador.setModel(new DefaultComboBoxModel(TipoActividadDesenpeniada.values()));
		comboBoxTipoTrabajador.setToolTipText("PROFESOR,\r\nPROFESORA,\r\nASISTENTA,\r\nASISTENTE,\r\nCOCINERO\r\nCOCINERA\r\nLIMPIADORA\r\nLIPIADOR\r\nJARDINERO\r\nJARDINERA\r\nENTRENADOR\r\nENTRENADORA");
		comboBoxTipoTrabajador.setBounds(423, 241, 148, 28);
		add(comboBoxTipoTrabajador);
		
		
		JLabel Fondo = new JLabel("");
		Fondo.setBounds(-23, 11, 891, 499);;
		Fondo.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\Ventana_UsusarioAPI.jpg"));
		add(Fondo);
		
	
	
		botonAceptar.addMouseListener(new MouseAdapter() {
			
			
		});
		
		
		
		
		
		


		
		
		
		
	
		
		
		
	
	
		
		
		
	
		
		
		
		


}
}


