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
import enums.Clases;
import enums.DiasSemana;
import enums.TipoCompra;
import exepciones.ContraseniaIncorrectaException;
import exepciones.UsuarioNoExisteException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PantallaExtraescolar extends JPanel {
	;
	private Ventana ventana;
	private final JLabel label = new JLabel("");
	private JTextField campoNombre;
	private JTextField campoImporte;
	private JTextField campoFecha;
	private JTextField campoNombreprofesor;
	private JTextField textField;
	private JTextField campoCodigoMovimiento;

	public PantallaExtraescolar(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton botonAtras = new BotonAzul("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.cambiarPantalla("queHacer");
				
			}
			
		
		});
		botonAtras.setBounds(10, 390, 89, 23);
		add(botonAtras);
		
		JLabel ExtraEscolar = new JLabel("ExtaEscolar");
		ExtraEscolar.setFont(new Font("Tahoma", Font.BOLD, 29));
		ExtraEscolar.setBounds(387, 44, 180, 50);
		add(ExtraEscolar);
		
		
		JLabel Nombre = new JLabel("Nombre");
		Nombre.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nombre.setToolTipText("");
		Nombre.setBounds(276, 200, 117, 23);
		add(Nombre);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(450, 204, 117, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel Fijo = new JLabel("Es fijo");
		Fijo.setToolTipText("");
		Fijo.setFont(new Font("Tahoma", Font.BOLD, 17));
		Fijo.setBounds(276, 234, 117, 23);
		add(Fijo);
		
		
		final JRadioButton siFijo = new JRadioButton("pulsar si es fijo");
		siFijo.setBounds(450, 237, 117, 23);
		add(siFijo);

		final JRadioButton noFijo = new JRadioButton("pulsar si no es fijo");
		noFijo.setBounds(579, 237, 117, 23);
		add(noFijo);
		
		JLabel Nombre_2 = new JLabel("Importe");
		Nombre_2.setToolTipText("");
		Nombre_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nombre_2.setBounds(276, 268, 117, 23);
		add(Nombre_2);
		
		campoImporte = new JTextField();
		campoImporte.setColumns(10);
		campoImporte.setBounds(450, 272, 117, 20);
		add(campoImporte);
		
		JLabel Fecha = new JLabel("Fecha");
		Fecha.setToolTipText("");
		Fecha.setFont(new Font("Tahoma", Font.BOLD, 17));
		Fecha.setBounds(276, 302, 117, 23);
		add(Fecha);
		
		campoFecha = new JTextField();
		campoFecha.setColumns(10);
		campoFecha.setBounds(450, 306, 117, 20);
		add(campoFecha);
		
		JLabel NombreProfesor = new JLabel("Nombre Profesor");
		NombreProfesor.setToolTipText("");
		NombreProfesor.setFont(new Font("Tahoma", Font.BOLD, 17));
		NombreProfesor.setBounds(276, 336, 146, 23);
		add(NombreProfesor);
		
		campoNombreprofesor = new JTextField();
		campoNombreprofesor.setColumns(10);
		campoNombreprofesor.setBounds(448, 337, 119, 20);
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
		
		
		final JComboBox comboBox_DiasSeman = new JComboBox();
		comboBox_DiasSeman.setModel(new DefaultComboBoxModel(DiasSemana.values()));
		comboBox_DiasSeman.setToolTipText("");
		comboBox_DiasSeman.setBounds(450, 407, 117, 22);
		add(comboBox_DiasSeman);
		
		final JComboBox conboBox_Clases = new JComboBox();
		conboBox_Clases.setModel(new DefaultComboBoxModel(Clases.values()));
		conboBox_Clases.setToolTipText("CIENCIA\r\nLETRAS\r\nIDIOMAS\r\nDEPORTE");
		conboBox_Clases.setBounds(450, 374, 117, 22);
		add(conboBox_Clases);
		
		JButton Rejistrar = new BotonVerde("Rejistrar");
		Rejistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				String nombre=campoNombre.getText();
				
				boolean importeFijo=true;
				
	            if (siFijo.isSelected()) {
	            	importeFijo=true;
	                
	            }
	            else if(noFijo.isSelected()) {
	            	importeFijo =false;
	            }
				float importe=Float.parseFloat(campoImporte.getText());
				String fechaEnTexto=campoFecha.getText();
				String[] fechaPartida=fechaEnTexto.split("/");
				LocalDate fecha=
		                LocalDate.of(Integer.parseInt(fechaPartida[2]),
		                                Integer.parseInt(fechaPartida[1]),
		                                Integer.parseInt(fechaPartida[0]));
				String nombreProfesor=campoNombreprofesor.getText();
				Clases clase=(Clases)conboBox_Clases.getSelectedItem();
				DiasSemana dias=(DiasSemana)comboBox_DiasSeman.getSelectedItem();
				int codigoMovimiento=Integer.parseInt(campoCodigoMovimiento.getText());
				
				
					new clases.ExtraEscolar(nombre,importeFijo,importe,fecha,nombreProfesor,clase,dias,codigoMovimiento);
					 JOptionPane.showMessageDialog(ventana,"Registro ok","Resgitro completado",JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					System.out.println(e1);
					e1.printStackTrace();
					JOptionPane.showMessageDialog(
			                ventana,e1.getMessage(),"Error",
			                JOptionPane.ERROR_MESSAGE);
				} catch (ArrayIndexOutOfBoundsException e1) {
	                JOptionPane.showMessageDialog(ventana, "Formato erroneo, debe ser dd/mm/yyyy","error",JOptionPane.ERROR_MESSAGE);
					
				}
				
					}
				
			});
		Rejistrar.setBounds(561, 461, 103, 27);
		add(Rejistrar);
		
		
		JButton btnlistaExtraEscolar = new BotonAzul("Lista ExtraEscolar");
		btnlistaExtraEscolar.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnlistaExtraEscolar.setText("Lista ExtraEscolar y Informe.txt ");
		btnlistaExtraEscolar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					clases.ExtraEscolar.imprimeInforme();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventana.cambiarPantalla("listaExtraEscolar");
			}
		});
		btnlistaExtraEscolar.setBounds(10, 433, 219, 23);
		add(btnlistaExtraEscolar);
		
		
		JLabel Clases = new JLabel("Dia Semana");
		Clases.setToolTipText("");
		Clases.setFont(new Font("Tahoma", Font.BOLD, 17));
		Clases.setBounds(276, 370, 117, 23);
		add(Clases);
		
		
		JLabel fondo = new JLabel("");
		fondo.setToolTipText("LUNES\r\nMARTES\r\nMIERCOLES\r\nJUEVES\r\nVIERNES\r\nSAVADO");
		fondo.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\VentanaGastos_de_casa_API.jpg"));
		fondo.setBounds(-23, 11, 891, 499);
		add(fondo);
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
	
		
	
		
	

	}
}
		
		
		
		
		
		
	
		
		
	
		
		
		


		
	
		
	

		



