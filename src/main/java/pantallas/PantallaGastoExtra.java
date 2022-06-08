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

public class PantallaGastoExtra extends JPanel {
	;
	private Ventana ventana;
	private final JLabel label = new JLabel("");
	private JTextField campoNombre;
	private JTextField campoImporte;
	private JTextField campoFecha;
	private JTextField campoCodigoMovimiento;

	public PantallaGastoExtra(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton botonAtras = new BotonAzul("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.cambiarPantalla("queHacer");
				
			}
			
		
		});
		botonAtras.setBounds(10, 370, 89, 23);
		add(botonAtras);
		
		JLabel GastoExtra = new JLabel("GastoExtra");
		GastoExtra.setFont(new Font("Tahoma", Font.BOLD, 29));
		GastoExtra.setBounds(387, 44, 180, 50);
		add(GastoExtra);
		
		
		JLabel Nombre = new JLabel("Nombre");
		Nombre.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nombre.setToolTipText("");
		Nombre.setBounds(276, 200, 117, 23);
		add(Nombre);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(417, 204, 117, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel Fijo = new JLabel("Es fijo");
		Fijo.setToolTipText("");
		Fijo.setFont(new Font("Tahoma", Font.BOLD, 17));
		Fijo.setBounds(276, 234, 117, 23);
		add(Fijo);
		
		
		final JRadioButton siFijo = new JRadioButton("pulsar si es fijo");
		siFijo.setBounds(417, 237, 117, 23);
		add(siFijo);
		
		final JRadioButton noFijo = new JRadioButton("pulsar no es fijo");
		noFijo.setBounds(543, 237, 117, 23);
		add(noFijo);
		
		
		JLabel Nombre_2 = new JLabel("Importe");
		Nombre_2.setToolTipText("");
		Nombre_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nombre_2.setBounds(276, 268, 117, 23);
		add(Nombre_2);
		
		campoImporte = new JTextField();
		campoImporte.setColumns(10);
		campoImporte.setBounds(417, 272, 117, 20);
		add(campoImporte);
		
		JLabel Fecha = new JLabel("Fecha");
		Fecha.setToolTipText("");
		Fecha.setFont(new Font("Tahoma", Font.BOLD, 17));
		Fecha.setBounds(276, 302, 117, 23);
		add(Fecha);
		
		campoFecha = new JTextField();
		campoFecha.setColumns(10);
		campoFecha.setBounds(417, 306, 117, 20);
		add(campoFecha);
		
		JLabel codigoMovimiento = new JLabel("CodigoMovimiento");
		codigoMovimiento.setToolTipText("");
		codigoMovimiento.setFont(new Font("Tahoma", Font.BOLD, 17));
		codigoMovimiento.setBounds(223, 383, 180, 23);
		add(codigoMovimiento);
		
		campoCodigoMovimiento = new JTextField();
		campoCodigoMovimiento.setColumns(10);
		campoCodigoMovimiento.setBounds(417, 387, 43, 20);
		add(campoCodigoMovimiento);
		
		
		BotonVerde Rejistrar = new BotonVerde("Rejistrar");
		Rejistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					String nombre= campoNombre.getText();
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
				
					
					int codigoMovimiento=Integer.parseInt(campoCodigoMovimiento.getText());
				
						new clases.GastoExtra(nombre,importeFijo,importe,fecha,codigoMovimiento);
						
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
		Rejistrar.setBounds(665, 403, 103, 27);
		add(Rejistrar);
		
		JButton botonListaGastosExtra = new BotonAzul("Lista GastosExtra y Informe.txt");
		botonListaGastosExtra.setFont(new Font("Dialog", Font.PLAIN, 13));
		botonListaGastosExtra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					clases.GastoExtra.imprimeInforme();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventana.cambiarPantalla("listaExtra");
				
			}
		});
		botonListaGastosExtra.setBounds(10, 424, 213, 23);
		add(botonListaGastosExtra);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\VentanaGastos_de_casa_API.jpg"));
		fondo.setBounds(-23, 11, 891, 499);
		add(fondo);
		

	
		
	
	
		
	
		
	

	}
}
		
		
		
		
		
		
	
		
		
	
		
		
		


		
	
		
	

		



