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
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.TipoCompra;
import enums.Clases;
import enums.DiasSemana;

public class PantallaServicio extends JPanel {
	;
	private Ventana ventana;
	private final JLabel label = new JLabel("");
	private JTextField campoNombre;
	private JTextField campoImporte;
	private JTextField campoFecha;
	private JTextField campoNombreprofesor;
	private JTextField textField;
	private JTextField campoCodigoMovimiento;

	public PantallaServicio(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton botonAtras = new BotonAzul("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.cambiarPantalla("queHacer");
				
			}
			
		
		});
		botonAtras.setBounds(10, 405, 89, 23);
		add(botonAtras);
		
		JLabel Servicio = new JLabel("Servicio");
		Servicio.setFont(new Font("Tahoma", Font.BOLD, 29));
		Servicio.setBounds(387, 44, 128, 50);
		add(Servicio);
		
		
		JLabel Nombre = new JLabel("Nombre");
		Nombre.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nombre.setToolTipText("");
		Nombre.setBounds(276, 200, 117, 23);
		add(Nombre);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(472, 204, 117, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel Fijo = new JLabel("Es fijo");
		Fijo.setToolTipText("");
		Fijo.setFont(new Font("Tahoma", Font.BOLD, 17));
		Fijo.setBounds(276, 234, 117, 23);
		add(Fijo);
		
		
		JRadioButton siFijo = new JRadioButton("pulsar si es fijo");
		siFijo.setBounds(472, 237, 117, 23);
		add(siFijo);

		
		JLabel Nombre_2 = new JLabel("Importe");
		Nombre_2.setToolTipText("");
		Nombre_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nombre_2.setBounds(276, 268, 117, 23);
		add(Nombre_2);
		
		campoImporte = new JTextField();
		campoImporte.setColumns(10);
		campoImporte.setBounds(472, 272, 117, 20);
		add(campoImporte);
		
		JLabel Fecha = new JLabel("Fecha");
		Fecha.setToolTipText("");
		Fecha.setFont(new Font("Tahoma", Font.BOLD, 17));
		Fecha.setBounds(276, 302, 117, 23);
		add(Fecha);
		
		campoFecha = new JTextField();
		campoFecha.setColumns(10);
		campoFecha.setBounds(472, 306, 117, 20);
		add(campoFecha);
		
		JLabel NombreTrabajador = new JLabel("Nombre Trabajador");
		NombreTrabajador.setToolTipText("");
		NombreTrabajador.setFont(new Font("Tahoma", Font.BOLD, 17));
		NombreTrabajador.setBounds(276, 336, 172, 23);
		add(NombreTrabajador);
		
		campoNombreprofesor = new JTextField();
		campoNombreprofesor.setColumns(10);
		campoNombreprofesor.setBounds(470, 337, 119, 20);
		add(campoNombreprofesor);
		
		JComboBox CBx_Clases = new JComboBox();
		
		
		JLabel codigoMovimiento = new JLabel("CodigoMovimiento");
		codigoMovimiento.setToolTipText("");
		codigoMovimiento.setFont(new Font("Tahoma", Font.BOLD, 17));
		codigoMovimiento.setBounds(227, 462, 180, 23);
		add(codigoMovimiento);
		
		campoCodigoMovimiento = new JTextField();
		campoCodigoMovimiento.setColumns(10);
		campoCodigoMovimiento.setBounds(417, 462, 43, 20);
		add(campoCodigoMovimiento);
		
		JLabel text_DiasSemana = new JLabel("Dia Semana");
		text_DiasSemana.setToolTipText("");
		text_DiasSemana.setFont(new Font("Tahoma", Font.BOLD, 17));
		text_DiasSemana.setBounds(276, 404, 117, 23);
		add(text_DiasSemana);
		
		
		JComboBox comboBox_DiasSeman = new JComboBox();
		comboBox_DiasSeman.setModel(new DefaultComboBoxModel(DiasSemana.values()));
		comboBox_DiasSeman.setToolTipText("");
		comboBox_DiasSeman.setBounds(450, 407, 117, 22);
		add(comboBox_DiasSeman);
		
		JButton Rejistrar = new BotonVerde("Rejistrar");
		Rejistrar.setBounds(561, 461, 103, 27);
		add(Rejistrar);
		
		
		
		JLabel Clases = new JLabel("Dia Semana");
		Clases.setToolTipText("");
		Clases.setFont(new Font("Tahoma", Font.BOLD, 17));
		Clases.setBounds(276, 370, 117, 23);
		add(Clases);
		
		JRadioButton noFijo = new JRadioButton("pulsar si no es  fijo");
		noFijo.setBounds(606, 237, 117, 23);
		add(noFijo);
		
		
		
		JLabel fondo = new JLabel("");
		fondo.setToolTipText("LUNES\r\nMARTES\r\nMIERCOLES\r\nJUEVES\r\nVIERNES\r\nSAVADO");
		fondo.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\VentanaGastos_de_casa_API.jpg"));
		fondo.setBounds(-23, 11, 891, 499);
		add(fondo);
		
		
		
		
	
		
		
	
		
	
		
	

	}
}
		
		
		
		
		
		
	
		
		
	
		
		
		


		
	
		
	

		



